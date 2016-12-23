package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.NewsTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface NewsTableService {
    //controller 部分应该包含生成前端列表以及内容的方法
    public Page<NewsTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public NewsTable save(NewsTable newsTable);

    public void delete(Long id);
}
