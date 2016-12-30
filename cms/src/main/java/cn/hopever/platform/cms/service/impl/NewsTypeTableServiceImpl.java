package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomNewsTypeTableRepository;
import cn.hopever.platform.cms.repository.NewsTypeTableRepository;
import cn.hopever.platform.cms.service.NewsTypeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("newsTypeTableService")
@Transactional
public class NewsTypeTableServiceImpl implements NewsTypeTableService {
    Logger logger = LoggerFactory.getLogger(NewsTypeTableServiceImpl.class);

    @Autowired
    private NewsTypeTableRepository newsTypeTableRepository;
    @Autowired
    private CustomNewsTypeTableRepository customNewsTypeTableRepository;

    @Override
    public Page<NewsTypeTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customNewsTypeTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public List<NewsTypeTable> getListByWebsites(List<WebsiteTable> list) {
        return newsTypeTableRepository.findByWebsiteIn(list);
    }

    @Override
    public NewsTypeTable save(NewsTypeTable newsTypeTable) {
        return newsTypeTableRepository.save(newsTypeTable);
    }

    @Override
    public void delete(Long id) {
        newsTypeTableRepository.delete(id);
    }

    @Override
    public NewsTypeTable get(Long id) {
        return newsTypeTableRepository.findOne(id);
    }
}
