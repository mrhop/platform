package cn.hopever.platform.cms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Donghui Huo on 2016/8/19.
 */
@SpringBootApplication
public class CmsApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
