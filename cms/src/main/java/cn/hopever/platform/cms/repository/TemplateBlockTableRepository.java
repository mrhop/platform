package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.TemplateBlockTable;
import cn.hopever.platform.cms.domain.TemplateTable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface TemplateBlockTableRepository extends PagingAndSortingRepository<TemplateBlockTable, Long> {
    void deleteByTemplate(TemplateTable templateTable);
}
