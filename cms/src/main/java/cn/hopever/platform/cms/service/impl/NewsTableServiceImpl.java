package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NewsTable;
import cn.hopever.platform.cms.service.NewsTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("newsTableService")
@Transactional
public class NewsTableServiceImpl implements NewsTableService {
    Logger logger = LoggerFactory.getLogger(NewsTableServiceImpl.class);

    @Override
    public Page<NewsTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public NewsTable save(NewsTable newsTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
