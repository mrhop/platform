package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.ClientTableRepository;
import cn.hopever.platform.user.repository.CustomModuleRoleTableRepository;
import cn.hopever.platform.user.repository.ModuleRoleTableRepository;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@Service("moduleRoleTableService")
@Transactional
public class ModuleRoleTableServiceImpl implements ModuleRoleTableService {
    Logger logger = LoggerFactory.getLogger(ModuleRoleTableServiceImpl.class);

    @Autowired
    private ModuleRoleTableRepository moduleRoleTableRepository;
    @Autowired
    private CustomModuleRoleTableRepository customModuleRoleTableRepository;

    @Autowired
    private ClientTableRepository clientTableRepository;

    @Autowired
    private UserTableRepository userTableRepository;

    @Override
    public List<ModuleRoleTable> getByClients(List<Object> clientIds) {

        List<ModuleRoleTable> list = new ArrayList<>();
        for (Object clientId : clientIds) {
            ClientTable clientTable = clientTableRepository.findOne(Long.parseLong(clientId.toString()));
            if (clientTable != null) {
                list.addAll(clientTable.getModuleRoles());
            }
        }
        return list;
    }

    @Override
    public List<ModuleRoleTable> getByIds(List<Object> ids) {
        List<ModuleRoleTable> list = new ArrayList<>();
        for (Object id : ids) {
            ModuleRoleTable moduleRoleTable = moduleRoleTableRepository.findOne(Long.parseLong(id.toString()));
            list.add(moduleRoleTable);
        }
        return list;
    }

    @Override
    public List<ModuleRoleTable> getByUserId(Long userId) {
        UserTable user = userTableRepository.findOne(userId);
        return user.getModulesAuthorities();
    }

    @Override
    public Page<ModuleRoleTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customModuleRoleTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public ModuleRoleTable getById(Long id) {
        return moduleRoleTableRepository.findOne(id);
    }

    @Override
    public ModuleRoleTable getByAuthority(String authority) {
        return moduleRoleTableRepository.findOneByAuthority(authority);
    }

    @Override
    public ModuleRoleTable save(ModuleRoleTable moduleRoleTable) {
        return moduleRoleTableRepository.save(moduleRoleTable);
    }

    @Override
    public void deleteById(Long id) {
        ModuleRoleTable  mrt = moduleRoleTableRepository.findOne(id);
        mrt.setModules(null);
        mrt.setClient(null);
        if(mrt.getUsers()!=null){
            for(UserTable ut:mrt.getUsers()){
                ut.getModulesAuthorities().remove(mrt);
            }
        }
        moduleRoleTableRepository.delete(mrt);
    }
}
