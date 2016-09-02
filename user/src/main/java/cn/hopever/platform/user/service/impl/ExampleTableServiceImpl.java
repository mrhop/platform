package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.repository.ExampleTableRepository;
import cn.hopever.platform.user.repository.ExampleTableRepositoryCustom;
import cn.hopever.platform.user.service.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Service
@Transactional
public class ExampleTableServiceImpl implements ExampleTableService {
    @Autowired
    private ExampleTableRepository testTableRepository;

    @Autowired
    private ExampleTableRepositoryCustom exampleTableRepositoryCustom;


    @Override
    public ExampleTable saveOne(ExampleTable exampleTable) {
        return testTableRepository.save(exampleTable);
    }

    @Override
    public void deleteOne(Integer id) {
        testTableRepository.delete(id);
    }
    @Override
    public ExampleTable getOneById(Integer id) {
        return testTableRepository.findOne(id);
    }

    @Override
    public ExampleTable getOneByUserName(String userName) {
        return testTableRepository.findByUserName(userName);
    }

    @Override
    public Iterable<ExampleTable> getByUserName(String userName) {
        return exampleTableRepositoryCustom.filterByUserName(userName);
    }

    @Override
    public Iterable<ExampleTable> findAll() {
        return testTableRepository.findAll();
    }
}
