package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleRoleTableRepository extends PagingAndSortingRepository<ModuleRoleTable, Long> {
    public ModuleRoleTable findOneByAuthority(String authority);
    public List<ModuleRoleTable> findByAuthorityLike(String authority, Pageable pageable);
}
