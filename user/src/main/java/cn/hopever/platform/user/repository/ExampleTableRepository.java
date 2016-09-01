package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ExampleTable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ExampleTableRepository extends CrudRepository<ExampleTable, Integer> {
    public ExampleTable findByUserName(String username);
}
