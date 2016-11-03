package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.UserTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

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

    public Page<UserTable> getListWithOutSelf(String username, Pageable pageable, Map<String, Object> filterMap);

    public Page<UserTable> getSubList(String username, Pageable pageable, Map<String, Object> filterMap);


    public void delete(Long id);

}
