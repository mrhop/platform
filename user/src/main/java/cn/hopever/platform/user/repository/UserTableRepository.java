package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface UserTableRepository extends PagingAndSortingRepository<UserTable, Long> {
    public UserTable findOneByUsername(String username);
    public List<UserTable> findByUsernameLike(String username, Pageable pageable);
    public Page<UserTable> findByAuthoritiesInAndClientsIn(Collection<RoleTable> authorities, Collection<ClientTable> clients, Pageable pageable);
    public Page<UserTable> findByUsernameNot(String username,Pageable pageable);

    public Page<UserTable> findByCreateUserAndAuthoritiesInAndClientsIn(UserTable userTable,Collection<RoleTable> authorities, Collection<ClientTable> clients, Pageable pageable);


    @Modifying
    @Query("update UserTable u set u.createUser = ?1 where u.createUser = ?2")
    int updateCreateUser(UserTable userTable, UserTable userTablePrev);
}
