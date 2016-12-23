package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.PollTable;
import cn.hopever.platform.cms.service.PollTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("pollTableService")
@Transactional
public class PollTableServiceImpl implements PollTableService {
    Logger logger = LoggerFactory.getLogger(PollTableServiceImpl.class);

    @Override
    public Page<PollTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public PollTable save(PollTable pollTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
