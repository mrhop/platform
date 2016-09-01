package cn.hopever.platform.user.test;

import cn.hopever.platform.user.web.hateoas.ExampleTableController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Donghui Huo on 2016/8/30.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ExampleTestMvc {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @InjectMocks
    ExampleTableController defaultRestController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    //
    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/example").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


}
