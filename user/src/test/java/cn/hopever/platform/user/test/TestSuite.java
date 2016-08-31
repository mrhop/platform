package cn.hopever.platform.user.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Donghui Huo on 2016/8/30.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExampleTestMvc.class,
        ExampleUserApplicationTest.class,
        ExampleTestMvcAllMock.class,
        ExampleTestMvc.class
})
public class TestSuite {
}
