package cn.hopever.platform.cms.config.moji;

import fm.last.moji.spring.SpringMojiBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Donghui Huo on 2016/12/9.
 */
@Configuration
public class MojiConfig {
    @Value("${moji.tracker.address}")
    private String address;
    @Value("${moji.pool.max.active}")
    private Integer poolMaxActive =100;
    @Value("${moji.pool.max.idle}")
    private Integer poolMaxIdle = 10;
    @Value("${moji.pool.test.on.borrow}")
    private Boolean testOnBorrow = true;

    @Bean(name="mojiImages")
    public SpringMojiBean getMojiImages(){
        SpringMojiBean moji = new SpringMojiBean();
        moji.setDomain("images");
        moji.setAddressesCsv(address);
        moji.setMaxActive(poolMaxActive);
        moji.setMaxIdle(poolMaxIdle);
        moji.setTestOnBorrow(testOnBorrow);
        return moji;
    }
    @Bean(name="mojiFiles")
    public SpringMojiBean getMojiFiles(){
        SpringMojiBean moji = new SpringMojiBean();
        moji.setDomain("files");
        moji.setAddressesCsv(address);
        moji.setMaxActive(poolMaxActive);
        moji.setMaxIdle(poolMaxIdle);
        moji.setTestOnBorrow(testOnBorrow);
        return moji;
    }

    @Bean(name="mojiDocs")
    public SpringMojiBean getMojiDocs(){
        SpringMojiBean moji = new SpringMojiBean();
        moji.setDomain("docs");
        moji.setAddressesCsv(address);
        moji.setMaxActive(poolMaxActive);
        moji.setMaxIdle(poolMaxIdle);
        moji.setTestOnBorrow(testOnBorrow);
        return moji;
    }


}
