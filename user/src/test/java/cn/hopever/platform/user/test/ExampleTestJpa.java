package cn.hopever.platform.user.test;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.repository.ExampleTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


/**
 * Created by Donghui Huo on 2016/8/30.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ExampleTestJpa {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ExampleTableRepository testTableRepository;


    @Test
    public void testExample() throws Exception {
        //this.entityManager.persist(new TestTable(1,"1234"));
        this.testTableRepository.save(new ExampleTable("1234"));
        ExampleTable testTable = this.testTableRepository.findByUserName("1234");
        assertEquals(testTable.getUserName(),"1234");
    }

}
