package cn.hopever.platform.user.test;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.service.ExampleTableService;
import cn.hopever.platform.user.web.hateoas.ExampleTableAssembler;
import cn.hopever.platform.user.web.hateoas.ExampleTableController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Donghui Huo on 2016/8/30.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ExampleTableController.class)
@AutoConfigureMockMvc
public class ExampleTestMvcAllMock {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ExampleTableService testTableService;
    @MockBean
    ExampleTableAssembler exampleTableAssembler;
    @MockBean
    ModelMapper modelMapper;


    //
    @Test
    public void testSayHelloWorld() throws Exception {
        ExampleTable et = new ExampleTable("youknow");
        //given(this.testTableService.addOne(et)).willReturn(et);
        this.mvc.perform(get("/example").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


}
