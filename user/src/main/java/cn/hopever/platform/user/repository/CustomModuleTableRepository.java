package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/12/2.
 */
public interface CustomModuleTableRepository {
    public Page<ModuleTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable, ClientTable userAdminClient);
}
