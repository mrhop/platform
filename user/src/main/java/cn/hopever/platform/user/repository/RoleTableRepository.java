package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.RoleTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface RoleTableRepository extends PagingAndSortingRepository<RoleTable, Long> {
    public RoleTable findOneByAuthority(String authority);
    public List<RoleTable> findByAuthorityLike(String authority,Pageable pageable);
}
