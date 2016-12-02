package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/12/2.
 */
public interface CustomModuleRoleTableRepository {
    public Page<ModuleRoleTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable);
}
