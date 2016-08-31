package cn.hopever.platform.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Donghui Huo on 2016/8/19.
 */
@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
