package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.ClientTableRepository;
import cn.hopever.platform.user.repository.CustomModuleTableRepository;
import cn.hopever.platform.user.repository.ModuleTableRepository;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.ModuleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@Service("moduleTableService")
@Transactional
public class ModuleTableServiceImpl implements ModuleTableService {

    Logger logger = LoggerFactory.getLogger(ModuleTableServiceImpl.class);

    @Autowired
    private ModuleTableRepository moduleTableRepository;
    @Autowired
    private CustomModuleTableRepository customModuleTableRepository;

    @Autowired
    private ClientTableRepository clientTableRepository;

    @Autowired
    private UserTableRepository userTableRepository;

    @Override
    public Iterable<ModuleTable> getListByClientAndAuthorityAndUser(String clientId, String authority, String username) {
        ClientTable ct = clientTableRepository.findOneByClientId(clientId);
        if ("ROLE_super_admin".equals(authority)) {
            return moduleTableRepository.findDistinctByParentAndClient(null, ct, new Sort("moduleOrder"));
        } else if ("ROLE_admin".equals(authority)) {
            if ("user_admin_client".equals(clientId)) {
                //手动过滤
                return moduleTableRepository.findDistinctByParentAndClientAndModuleName(null, ct, "User Mgmt", new Sort("moduleOrder"));
                //过滤掉Role，moduleRole，Module。client，client Role，只留存user部分的与该admin同一client的用户的处理
            } else {
                return moduleTableRepository.findDistinctByParentAndClient(null, ct, new Sort("moduleOrder"));
            }
        } else if ("ROLE_common_user".equals(authority)) {
            if ("user_admin_client".equals(clientId)) {
                //手动过滤
                //过滤掉Role，moduleRole，Module。client，client Role，只留存user部分的个人信息处理
                Iterable<ModuleTable> moduleTables = moduleTableRepository.findDistinctByParentAndClientAndModuleName(null, ct, "User Mgmt", new Sort("moduleOrder"));
                for (ModuleTable mt : moduleTables) {
                    mt.setChildren(moduleTableRepository.findDistinctByParentAndClientAndModuleNameLike(mt, ct, "Personal Info", new Sort("moduleOrder")));
                }
                return moduleTables;
            } else {
                //自动过滤
                UserTable ut = userTableRepository.findOneByUsername(username);
                if (ut.getModulesAuthorities() != null) {
                    Iterable<ModuleTable> moduleTables = moduleTableRepository.findDistinctByParentAndClientAndAuthoritiesIn(null, ct, ut.getModulesAuthorities(), new Sort("moduleOrder"));
                    for (ModuleTable mt : moduleTables) {
                        if (mt.getChildren() != null) {
                            mt.setChildren(moduleTableRepository.findDistinctByParentAndClientAndAuthoritiesIn(mt, ct, ut.getModulesAuthorities(), new Sort("moduleOrder")));
                        }
                    }
                    return moduleTables;
                }
            }
        }
        return null;
    }

    @Override
    public Iterable<ModuleTable> getAll() {
        return this.moduleTableRepository.findAll();
    }

    @Override
    public Page<ModuleTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        //将filter进行处理，并把client以及parent根据id抽取出来，并形成实体~~~
        if (filterMap != null && filterMap.size() > 0) {
            for (String key : filterMap.keySet()) {
                if (key.equals("parent")) {
                    filterMap.put(key, moduleTableRepository.findOne(Long.valueOf(filterMap.get(key).toString())));
                } else if (key.equals("client")) {
                    filterMap.put(key, clientTableRepository.findOne(Long.valueOf(filterMap.get(key).toString())));
                }else if (key.equals("activated")) {
                    filterMap.put(key, Boolean.valueOf(filterMap.get(key).toString()));
                }
            }
        }
        return customModuleTableRepository.findByFilters(filterMap, pageable, this.clientTableRepository.findOneByClientId("user_admin_client"));
    }

    @Override
    public ModuleTable getById(Long id) {
        return this.moduleTableRepository.findOne(id);
    }

    @Override
    public ModuleTable save(ModuleTable moduleTable) {
        return this.moduleTableRepository.save(moduleTable);
    }

    @Override
    public void deleteById(Long id) {
        //删除时，去除关联并删除子
        ModuleTable mt = moduleTableRepository.findOne(id);
        this.moduleTableRepository.delete(id);
    }

    @Override
    public List<ModuleTable> getParentList() {
        return this.moduleTableRepository.findDistinctByParentIsNullAndModuleOrderNotNullAndAvailableAndClientNot(true,this.clientTableRepository.findOneByClientId("user_admin_client"), new Sort("moduleOrder"));
    }

    @Override
    public List<ModuleTable> getParentListByClient(ClientTable ct) {
        return this.moduleTableRepository.findDistinctByParentIsNullAndAvailableAndClient(true,ct,new Sort("moduleOrder"));
    }
}
