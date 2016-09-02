package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ExampleTable;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ExampleTableRepositoryCustom{
    public Iterable<ExampleTable> filterByUserName(String username);
}
