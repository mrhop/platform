package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NewsTypeTable;
import cn.hopever.platform.cms.service.NewsTypeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("newsTypeTableService")
@Transactional
public class NewsTypeTableServiceImpl implements NewsTypeTableService {
    Logger logger = LoggerFactory.getLogger(NewsTypeTableServiceImpl.class);

    @Override
    public List<NewsTypeTable> getList() {
        return null;
    }

    @Override
    public NewsTypeTable save(NewsTypeTable newsTypeTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
