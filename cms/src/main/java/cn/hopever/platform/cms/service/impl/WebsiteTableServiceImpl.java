package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomWebsiteTableRepository;
import cn.hopever.platform.cms.repository.WebsiteTableRepository;
import cn.hopever.platform.cms.service.WebsiteTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("websiteTableService")
@Transactional
public class WebsiteTableServiceImpl implements WebsiteTableService {
    Logger logger = LoggerFactory.getLogger(WebsiteTableServiceImpl.class);

    @Autowired
    private WebsiteTableRepository websiteTableRepository;
    @Autowired
    private CustomWebsiteTableRepository customUserTableRepository;

    @Override
    public Page<WebsiteTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customUserTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public WebsiteTable save(WebsiteTable websiteTable) {
        return websiteTableRepository.save(websiteTable);
    }

    @Override
    public void delete(Long id) {
        websiteTableRepository.delete(id);
    }
}
