package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface UserTableRepository extends PagingAndSortingRepository<UserTable, Long> {
    public UserTable findOneByUsername(String username);
    public List<RoleTable> findByUsernameLike(String username, Pageable pageable);
}
