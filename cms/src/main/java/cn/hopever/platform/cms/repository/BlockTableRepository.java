package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.BlockTable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface BlockTableRepository extends PagingAndSortingRepository<BlockTable, Long> {
}
