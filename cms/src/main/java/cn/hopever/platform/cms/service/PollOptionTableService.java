package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.PollOptionTable;
import cn.hopever.platform.cms.domain.PollTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface PollOptionTableService {
    //根据poll的id获取相关的polloption，然后处理
    public List<PollOptionTable> getListByPoll(PollTable pollTable);

    public PollOptionTable save(PollOptionTable pollOptionTable);

    public void delete(Long id);
}
