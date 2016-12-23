package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.service.WebsiteTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("websiteTableService")
@Transactional
public class WebsiteTableServiceImpl implements WebsiteTableService {
    Logger logger = LoggerFactory.getLogger(WebsiteTableServiceImpl.class);

    @Override
    public Page<WebsiteTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public WebsiteTable save(WebsiteTable websiteTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
