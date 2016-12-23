package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.ArticleTable;
import cn.hopever.platform.cms.service.ArticleTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("articleTableService")
@Transactional
public class ArticleTableServiceImpl implements ArticleTableService {
    Logger logger = LoggerFactory.getLogger(ArticleTableServiceImpl.class);

    @Override
    public Page<ArticleTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public ArticleTable save(ArticleTable articleTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
