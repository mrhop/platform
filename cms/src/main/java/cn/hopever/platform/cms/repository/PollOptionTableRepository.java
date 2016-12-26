package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.PollOptionTable;
import cn.hopever.platform.cms.domain.PollTable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 * 全部采用
 */
public interface PollOptionTableRepository extends PagingAndSortingRepository<PollOptionTable, Long> {
    public List<PollOptionTable> findByPoll(PollTable poll);
}
