package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.ArticleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ArticleTableService {

    public Page<ArticleTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public ArticleTable save(ArticleTable articleTable);

    public void delete(Long id);

    public ArticleTable get(Long id);

}
