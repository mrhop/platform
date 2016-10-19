package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.UserTable;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
//need to use this as the userdetailservice,then return the true things there
// then implict
// then password
// then client then consider about the different system to use,like cms crm,etc
public interface UserTableService extends UserDetailsService {
    public UserTable save(UserTable user);

    public UserTable getUserByUsername(String username);

    public Iterable<UserTable> getList();

    public Iterable<UserTable> getSubList(String username);

}
