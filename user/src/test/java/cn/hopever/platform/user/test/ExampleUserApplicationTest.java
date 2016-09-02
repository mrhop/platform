package cn.hopever.platform.user.test;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.service.ExampleTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Donghui Huo on 2016/8/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleUserApplicationTest {
    static Logger logger = LoggerFactory.getLogger(ExampleUserApplicationTest.class);

    @Autowired
    private ExampleTableService testTableService;

    @Test
    public void contextLoads() {
        logger.debug("init finished");
    }

    @Test
    public void  addtest() {
        testTableService.saveOne(new ExampleTable("you know"));
    }

    @Test
    public void  findall() {
        testTableService.findAll();
    }
}
