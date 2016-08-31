package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ExampleTable;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ExampleTableService {

    public String insertOne();
    public Iterable<ExampleTable> findAll();

}
