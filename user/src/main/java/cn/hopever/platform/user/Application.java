package cn.hopever.platform.user;

import cn.hopever.platform.user.config.ConfigTest1Properties;
import cn.hopever.platform.user.config.ConfigTest2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghui Huo on 2016/8/19.
 */
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private ConfigTest1Properties configTest1Properties;
    @Autowired
    private ConfigTest2Properties configTest2Properties;

    @RequestMapping("/")
    String home() {
        return "Hello World!" + configTest1Properties.getName()+"--"+configTest2Properties.getDesc();
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
