package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ExampleTable;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ExampleTableService {

    public ExampleTable saveOne(ExampleTable exampleTable);
    public void deleteOne(Integer id);
    public ExampleTable getOneById(Integer id);
    public ExampleTable getOneByUserName(String userName);
    public Iterable<ExampleTable> getByUserName(String userName);
    public Iterable<ExampleTable> findAll();

}
