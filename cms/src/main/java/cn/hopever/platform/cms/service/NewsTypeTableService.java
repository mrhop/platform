package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.NewsTypeTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface NewsTypeTableService {

    public List<NewsTypeTable> getList();

    public NewsTypeTable save(NewsTypeTable newsTypeTable);

    public void delete(Long id);

}
