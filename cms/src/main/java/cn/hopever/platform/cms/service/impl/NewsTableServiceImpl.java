package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NewsTable;
import cn.hopever.platform.cms.repository.CustomNewsTableRepository;
import cn.hopever.platform.cms.repository.NewsTableRepository;
import cn.hopever.platform.cms.service.NewsTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("newsTableService")
@Transactional
public class NewsTableServiceImpl implements NewsTableService {
    Logger logger = LoggerFactory.getLogger(NewsTableServiceImpl.class);

    @Autowired
    private NewsTableRepository newsTableRepository;
    @Autowired
    private CustomNewsTableRepository customNewsTableRepository;

    @Override
    public Page<NewsTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customNewsTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public NewsTable save(NewsTable newsTable) {
        return newsTableRepository.save(newsTable);
    }

    @Override
    public void delete(Long id) {
        newsTableRepository.delete(id);
    }

    @Override
    public NewsTable get(Long id) {
        return newsTableRepository.findOne(id);
    }
}
