package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.NavigateTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface NavigateTableService {

    //同样前端也需要生成一个格式化后的数据
    public Page<NavigateTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public NavigateTable save(NavigateTable navigateTable);

    public void delete(Long id);
}
