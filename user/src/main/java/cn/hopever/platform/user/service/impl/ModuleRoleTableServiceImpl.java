package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.repository.ModuleRoleTableRepository;
import cn.hopever.platform.user.service.ModuleRoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@Service("moduleRoleTableService")
@Transactional
public class ModuleRoleTableServiceImpl implements ModuleRoleTableService {
    Logger logger = LoggerFactory.getLogger(ModuleRoleTableServiceImpl.class);

    @Autowired
    private ModuleRoleTableRepository moduleRoleTableRepository;
}
