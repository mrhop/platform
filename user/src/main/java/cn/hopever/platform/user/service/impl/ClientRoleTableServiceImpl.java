package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.repository.ClientRoleTableRepository;
import cn.hopever.platform.user.service.ClientRoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@Service("clientRoleTableService")
@Transactional
public class ClientRoleTableServiceImpl implements ClientRoleTableService {

    Logger logger = LoggerFactory.getLogger(ClientRoleTableServiceImpl.class);

    @Autowired
    private ClientRoleTableRepository clientRoleTableRepository;
}