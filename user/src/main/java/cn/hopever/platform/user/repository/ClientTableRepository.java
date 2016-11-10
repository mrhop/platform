package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.UserTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ClientTableRepository extends PagingAndSortingRepository<ClientTable, Long> {
    public ClientTable findOneByClientId(String clientId);
    public List<ClientTable> findByClientIdLike(String clientId);
    public List<ClientTable> findByUsersIn(Collection<UserTable> users);
    public List<ClientTable> findByClientIdLike(String clientId, Pageable pageable);
}
