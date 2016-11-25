package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.CustomUserTableRepository;
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
import java.util.Map;

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
    private CustomUserTableRepository customUserTableRepository;

    @Autowired
    private RoleTableRepository roleTableRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTable user = userTableRepository.findOneByUsername(username);
        if(user==null){
            user = userTableRepository.findOneByPhone(username);
        }
        if(user==null){
            user = userTableRepository.findOneByEmail(username);
        }
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
        UserTable ut = userTableRepository.findOneByUsername(username);
        return ut;
    }

    @Override
    public UserTable getUserByEmail(String email) {
        return userTableRepository.findOneByEmail(email);
    }

    @Override
    public UserTable getUserByPhone(String phone) {
        return userTableRepository.findOneByPhone(phone);
    }

    @Override
    public Iterable<UserTable> getList() {
        return userTableRepository.findAll();
    }

    @Override
    public Page<UserTable> getListWithOutSelf(String username, Pageable pageable, Map<String, Object> filterMap) {
        if (filterMap == null) {
            return userTableRepository.findByUsernameNot(username, pageable);
        } else {
            return customUserTableRepository.findByUsernameNotAndFilters(username, filterMap, pageable);
        }
    }

    @Override
    public Page<UserTable> getSubList(String username, Pageable pageable, Map<String, Object> filterMap) {
        UserTable ut = userTableRepository.findOneByUsername(username);
        List<RoleTable> list = new ArrayList<>();
        list.add(roleTableRepository.findOneByAuthority("ROLE_admin"));
        list.add(roleTableRepository.findOneByAuthority("ROLE_common_user"));
        if (filterMap == null) {
            return userTableRepository.findByCreateUserAndAuthoritiesInAndClientsIn(ut, list, ut.getClients(), pageable);
        } else {
            return customUserTableRepository.findByCreateUserAndAuthoritiesInAndClientsInAndFilters(ut, list, ut.getClients(), filterMap, pageable);
        }
    }

    @Override
    public void delete(Long id) {
        this.userTableRepository.updateCreateUser(null, this.userTableRepository.findOne(id));
        this.userTableRepository.delete(id);
    }

    @Override
    public UserTable get(Long id) {
        return this.userTableRepository.findOne(id);
    }
}
