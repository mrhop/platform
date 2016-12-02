package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleRoleTableService {
    public List<ModuleRoleTable> getByClients(List<Object> clientIds);
    public List<ModuleRoleTable> getByIds(List<Object> ids);
    public List<ModuleRoleTable> getByUserId(Long userId);

    public Page<ModuleRoleTable> getList(Pageable pageable, Map<String, Object> filterMap);
    public ModuleRoleTable getById(Long id);
    public ModuleRoleTable getByAuthority(String authority);
    public ModuleRoleTable save(ModuleRoleTable moduleRoleTable);
    public void deleteById(Long id);

}
