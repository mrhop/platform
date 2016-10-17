package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.ClientTableRepository;
import cn.hopever.platform.user.repository.ModuleTableRepository;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.ModuleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ClientTableRepository clientTableRepository;

    @Autowired
    private UserTableRepository userTableRepository;

    @Override
    public Iterable<ModuleTable> getListByClientAndAuthorityAndUser(String clientId, String authority, String username) {
        ClientTable ct = clientTableRepository.findOneByClientId(clientId);
        if ("super_admin".equals(authority)) {
            return  moduleTableRepository.findByParentAndClient(null, ct);
        } else if ("admin".equals(authority)) {
            if ("user_admin_client".equals(clientId)) {
                //手动过滤
                return moduleTableRepository.findByParentAndClientAndModuleName(null,ct,"User Mgmt");
                //过滤掉Role，moduleRole，Module。client，client Role，只留存user部分的与该admin同一client的用户的处理
            } else {
                return  moduleTableRepository.findByParentAndClient(null, ct);
            }
        } else if ("common_user".equals(authority)) {
            if ("user_admin_client".equals(clientId)) {
                //手动过滤
                //过滤掉Role，moduleRole，Module。client，client Role，只留存user部分的个人信息处理
                Iterable<ModuleTable> moduleTables =  moduleTableRepository.findByParentAndClientAndModuleName(null,ct,"User Mgmt");
                for(ModuleTable mt: moduleTables){
                    mt.setChildren(moduleTableRepository.findByParentAndClientAndModuleNameLike(mt,ct,"Personal Info"));
                }
                return moduleTables;
            } else {
                //自动过滤
                UserTable ut = userTableRepository.findOneByUsername(username);
                if(ut.getModulesAuthorities()!=null){
                    Iterable<ModuleTable> moduleTables = moduleTableRepository.findByParentAndClientAndAuthoritiesIn(null,ct,ut.getModulesAuthorities());
                    for(ModuleTable mt: moduleTables){
                        if(mt.getChildren()!=null){
                            mt.setChildren(moduleTableRepository.findByParentAndClientAndAuthoritiesIn(mt,ct,ut.getModulesAuthorities()));
                        }
                    }
                    return moduleTables;
                }
            }
        }
        return null;
    }
}
