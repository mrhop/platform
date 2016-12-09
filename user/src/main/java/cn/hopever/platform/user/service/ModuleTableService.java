package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleTableService {

    public Iterable<ModuleTable> getListByClientAndAuthorityAndUser(String clientId, String authority, String username);
    public Iterable<ModuleTable> getAll();

    public Page<ModuleTable> getList(Pageable pageable, Map<String, Object> filterMap);
    public ModuleTable getById(Long id);
    public ModuleTable save(ModuleTable moduleTable);
    public void deleteById(Long id);
    public List<ModuleTable> getParentList();
    public List<ModuleTable> getParentListByClient(ClientTable ct);

}
