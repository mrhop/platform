package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.PollTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface PollTableService {

    //投票系统的新增以及其他处理
    public Page<PollTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public PollTable save(PollTable pollTable);

    public void delete(Long id);

}
