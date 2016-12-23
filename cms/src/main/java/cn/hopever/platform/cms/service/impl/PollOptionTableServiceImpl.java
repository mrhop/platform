package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.PollOptionTable;
import cn.hopever.platform.cms.domain.PollTable;
import cn.hopever.platform.cms.service.PollOptionTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pollOptionTableService")
@Transactional
public class PollOptionTableServiceImpl implements PollOptionTableService {
    Logger logger = LoggerFactory.getLogger(PollOptionTableServiceImpl.class);

    @Override
    public List<PollOptionTable> getListByPoll(PollTable pollTable) {
        return null;
    }

    @Override
    public PollOptionTable save(PollOptionTable pollOptionTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
