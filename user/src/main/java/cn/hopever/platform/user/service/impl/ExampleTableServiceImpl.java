package cn.hopever.platform.user.service.impl;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.repository.ExampleTableRepository;
import cn.hopever.platform.user.service.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
@Service
public class ExampleTableServiceImpl implements ExampleTableService {
    @Autowired
    private ExampleTableRepository testTableRepository;

    @Override
    public String insertOne() {
        ExampleTable testTable = new ExampleTable();
        testTable.setUserName("you know");
        return testTableRepository.save(testTable).getUserName();
    }

    @Override
    public Iterable<ExampleTable> findAll() {
        return testTableRepository.findAll();
    }
}
