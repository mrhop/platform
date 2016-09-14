package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.UserTable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface UserTableRepository extends CrudRepository<UserTable, Integer> {
    public UserTable findOneByUsername(String username);
}