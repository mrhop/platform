package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.PollOptionTable;
import cn.hopever.platform.cms.repository.PollOptionTableRepository;
import cn.hopever.platform.cms.repository.PollTableRepository;
import cn.hopever.platform.cms.repository.WebsiteTableRepository;
import cn.hopever.platform.cms.service.PollOptionTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pollOptionTableService")
@Transactional
public class PollOptionTableServiceImpl implements PollOptionTableService {
    Logger logger = LoggerFactory.getLogger(PollOptionTableServiceImpl.class);

    @Autowired
    private WebsiteTableRepository websiteTableRepository;
    @Autowired
    private PollTableRepository pollTableRepository;
    @Autowired
    private PollOptionTableRepository pollOptionTableRepository;

    @Override
    public List<PollOptionTable> getListByPoll(Long pollId) {
        return pollOptionTableRepository.findByPoll(pollTableRepository.findOne(pollId));
    }

    @Override
    public PollOptionTable save(PollOptionTable pollOptionTable) {
        return this.pollOptionTableRepository.save(pollOptionTable);
    }

    @Override
    public void delete(Long id) {
        this.pollOptionTableRepository.delete(id);
    }

    @Override
    public PollOptionTable get(Long id) {
        return pollOptionTableRepository.findOne(id);
    }
}
