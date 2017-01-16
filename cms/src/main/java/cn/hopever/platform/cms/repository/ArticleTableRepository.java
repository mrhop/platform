package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.ArticleTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface ArticleTableRepository extends PagingAndSortingRepository<ArticleTable, Long> {
    public List<ArticleTable> findByWebsite(WebsiteTable websiteTable);
}
