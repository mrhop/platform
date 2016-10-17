package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientRoleTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ClientRoleTableRepository extends PagingAndSortingRepository<ClientRoleTable, Long> {
    public ClientRoleTable findOneByAuthority(String authority);
    public List<ClientRoleTable> findByAuthorityLike(String authority, Pageable pageable);
}
