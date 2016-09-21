package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.repository.ClientTableRepository;
import cn.hopever.platform.user.service.ClientTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghui Huo on 2016/9/12.
 */
@Service("clientTableService")
@Transactional
public class ClientTableServiceImpl implements ClientTableService {

    @Autowired
    private ClientTableRepository clientTableRepository;
    @Override
    public ClientTable save(ClientTable client) {
        return clientTableRepository.save(client);
    }

    @Override
    public ClientTable getClientByName(String clientname) {
        return clientTableRepository.findOneByClientname(clientname);
    }
}
