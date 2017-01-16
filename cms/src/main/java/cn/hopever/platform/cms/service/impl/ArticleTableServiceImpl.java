package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.ArticleTable;
import cn.hopever.platform.cms.repository.ArticleTableRepository;
import cn.hopever.platform.cms.repository.CustomArticleTableRepository;
import cn.hopever.platform.cms.repository.WebsiteTableRepository;
import cn.hopever.platform.cms.service.ArticleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("articleTableService")
@Transactional
public class ArticleTableServiceImpl implements ArticleTableService {
    Logger logger = LoggerFactory.getLogger(ArticleTableServiceImpl.class);

    @Autowired
    private WebsiteTableRepository websiteTableRepository;
    @Autowired
    private ArticleTableRepository articleTableRepository;
    @Autowired
    private CustomArticleTableRepository customArticleTableRepository;

    @Override
    public Page<ArticleTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customArticleTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public ArticleTable save(ArticleTable articleTable) {
        return articleTableRepository.save(articleTable);
    }

    @Override
    public void delete(Long id) {
        articleTableRepository.delete(id);
    }

    @Override
    public ArticleTable get(Long id) {
        return articleTableRepository.findOne(id);
    }

    @Override
    public List<ArticleTable> getListByWebsite(Long websiteId) {
        return articleTableRepository.findByWebsite(websiteTableRepository.findOne(websiteId));
    }
}
