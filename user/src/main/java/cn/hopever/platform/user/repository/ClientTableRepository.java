package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.RoleTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ClientTableRepository extends PagingAndSortingRepository<ClientTable, Long> {
    public ClientTable findOneByClientId(String clientId);
    public List<RoleTable> findByClientIdLike(String clientId, Pageable pageable);
}
