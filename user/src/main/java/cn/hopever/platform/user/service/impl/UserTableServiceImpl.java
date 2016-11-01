package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.RoleTableRepository;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.UserTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Service("userTableService")
@Transactional
public class UserTableServiceImpl implements UserTableService {

    Logger logger = LoggerFactory.getLogger(UserTableServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserTableRepository userTableRepository;

    @Autowired
    private RoleTableRepository roleTableRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userTableRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username " + username
                    + " not found");
        }
        return user;
    }

    @Override
    public UserTable save(UserTable user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userTableRepository.save(user);
    }

    @Override
    public UserTable getUserByUsername(String username) {
        return userTableRepository.findOneByUsername(username);
    }

    @Override
    public Iterable<UserTable> getList() {
        return userTableRepository.findAll();
    }

    @Override
    public Page<UserTable> getListWithOutSelf(String username,Pageable pageable) {
        return userTableRepository.findByUsernameNot(username,pageable);
    }

    @Override
    public Page<UserTable> getSubList(String username, Pageable pageable) {
        UserTable ut = userTableRepository.findOneByUsername(username);
        List<RoleTable> list = new ArrayList<>();
        list.add(roleTableRepository.findOneByAuthority("ROLE_common_user"));
        return userTableRepository.findByAuthoritiesInAndClientsIn(list, ut.getClients(),pageable);
    }


}
