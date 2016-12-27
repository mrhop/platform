package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface NewsTypeTableService {

    public List<NewsTypeTable> getList( Map<String, Object> filterMap);

    public List<NewsTypeTable> getListByWebsites(List<WebsiteTable> list);

    public NewsTypeTable save(NewsTypeTable newsTypeTable);

    public void delete(Long id);

    public NewsTypeTable get(Long id);

}
