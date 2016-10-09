package cn.hopever.platform.navigate.web.rest;

import cn.hopever.platform.navigate.config.PlatformConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/9/14.
 */
@RestController
@RequestMapping(value = "/platform", produces = "application/json")
public class PlatformController {
    @Autowired
    private PlatformConfig platformConfig;
//    @Autowired
//    private RedisTemplate redisTemplate;

    @RequestMapping("")
    //@CrossOrigin
    public List<HashMap<String, String>> getPlatformList() {
        return platformConfig.getList();

//        if(redisTemplate.hasKey("platform-lists")){
//            return (List)redisTemplate.opsForList().leftPop("platform-lists");
//        }else{
//            redisTemplate.opsForList().leftPush("platform-lists",platformConfig.getList());
//            return platformConfig.getList();
//        }
    }

}
