package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.repository.RoleTableRepository;
import cn.hopever.platform.user.service.RoleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/10/17.
 */
@Service("roleTableService")
@Transactional
public class RoleTableServiceImpl implements RoleTableService {

    Logger logger = LoggerFactory.getLogger(RoleTableServiceImpl.class);

    @Autowired
    private RoleTableRepository roleTableRepository;

    @Override
    public RoleTable save(RoleTable role) {
        return null;
    }

    @Override
    public RoleTable update(RoleTable role) {
        return null;
    }

    @Override
    public List<RoleTable> getList(String authority) {
        return null;
    }

    @Override
    public Iterable<RoleTable> getList() {
         Iterable<RoleTable> rt =  roleTableRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        return rt;
    }

    @Override
    public RoleTable get(Long id) {
        return roleTableRepository.findOne(id);
    }
}
