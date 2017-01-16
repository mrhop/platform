package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.PollTable;
import cn.hopever.platform.cms.repository.CustomPollTableRepository;
import cn.hopever.platform.cms.repository.PollTableRepository;
import cn.hopever.platform.cms.repository.WebsiteTableRepository;
import cn.hopever.platform.cms.service.PollTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("pollTableService")
@Transactional
public class PollTableServiceImpl implements PollTableService {
    Logger logger = LoggerFactory.getLogger(PollTableServiceImpl.class);

    @Autowired
    private WebsiteTableRepository websiteTableRepository;
    @Autowired
    private PollTableRepository pollTableRepository;
    @Autowired
    private CustomPollTableRepository customPollTableRepository;

    @Override
    public Page<PollTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customPollTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public PollTable save(PollTable pollTable) {
        return this.pollTableRepository.save(pollTable);
    }

    @Override
    public void delete(Long id) {
        this.pollTableRepository.delete(id);
    }

    @Override
    public PollTable get(Long id) {
        return pollTableRepository.findOne(id);
    }

    @Override
    public List<PollTable> getListByWebsite(Long websiteId) {
        return pollTableRepository.findByWebsite(websiteTableRepository.findOne(websiteId));
    }
}
