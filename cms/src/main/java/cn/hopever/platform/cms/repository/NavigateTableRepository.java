package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.NavigateTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface NavigateTableRepository extends PagingAndSortingRepository<NavigateTable, Long> {
    List<NavigateTable> findByWebsiteAndParentIsNull(WebsiteTable websiteTable,Sort sort);
}
