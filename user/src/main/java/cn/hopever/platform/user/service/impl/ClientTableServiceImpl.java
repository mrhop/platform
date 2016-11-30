package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.ClientTableRepository;
import cn.hopever.platform.user.repository.CustomClientTableRepository;
import cn.hopever.platform.user.repository.UserTableRepository;
import cn.hopever.platform.user.service.ClientTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/9/12.
 */
@Service("clientTableService")
@Transactional
public class ClientTableServiceImpl implements ClientTableService {

    Logger logger = LoggerFactory.getLogger(ClientTableServiceImpl.class);

    @Autowired
    private ClientTableRepository clientTableRepository;

    @Autowired
    private CustomClientTableRepository customClientTableRepository;

    @Autowired
    private UserTableRepository userTableRepository;

    @Override
    public ClientTable save(ClientTable client) {
        return clientTableRepository.save(client);
    }

    @Override
    public ClientTable getById(Long id) {
        return clientTableRepository.findOne(id);
    }

    @Override
    public Iterable<ClientTable> getAll() {
        return clientTableRepository.findAll();
    }

    @Override
    public List<ClientTable> getByUserName(String userName) {
        UserTable ut = userTableRepository.findOneByUsername(userName);
        List<UserTable> list = new ArrayList<>();
        list.add(ut);
        return clientTableRepository.findByUsersIn(list);
    }

    @Override
    public List<ClientTable> getByUserId(Long userId) {
        UserTable ut = userTableRepository.findOne(userId);
        List<UserTable> list = new ArrayList<>();
        list.add(ut);
        return clientTableRepository.findByUsersIn(list);
    }

    @Override
    public List<ClientTable> getByIds(List<Object> ids) {
        List<ClientTable> list = new ArrayList<>();
        for(Object id: ids){
            list.add(clientTableRepository.findOne(Long.parseLong(id.toString())));
        }
        return list;
    }

    @Override
    public Page<ClientTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customClientTableRepository.findByFilters(filterMap,pageable);
    }


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetails cd = clientTableRepository.findOneByClientId(clientId);
        if (cd == null) {
            logger.error("there is no client of id: " + clientId);
        }
        return cd;
    }
}
