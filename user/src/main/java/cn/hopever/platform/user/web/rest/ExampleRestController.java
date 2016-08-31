package cn.hopever.platform.user.web.rest;

import cn.hopever.platform.user.config.ExampleConfigProperties;
import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.service.ExampleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghui Huo on 2016/8/29.
 */
@RestController
public class ExampleRestController {
    @Autowired
    private ExampleTableService testTableService;

    @Autowired
    private ExampleConfigProperties configTest1Properties;

    @RequestMapping("/")
    String home() {
        return "Hello World!" + configTest1Properties.getPath();
    }

    @RequestMapping("/addtest")
    String addtest() {
        return testTableService.insertOne();
    }

    @RequestMapping("/findall")
    Iterable<ExampleTable> findall() {
        return testTableService.findAll();
    }
}
