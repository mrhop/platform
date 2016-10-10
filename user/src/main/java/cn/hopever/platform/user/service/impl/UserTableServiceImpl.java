package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Service("userTableService")
@Transactional
public class UserTableServiceImpl implements UserTableService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserTableRepository userTableRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userTableRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username " + username
                    + " not found");
        }
        //比对user 密码
        return user;
    }

    @Override
    public UserTable save(UserTable user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userTableRepository.save(user);
    }
}
