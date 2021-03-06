package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.TemplateTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomTemplateTableRepository;
import cn.hopever.platform.cms.repository.TemplateBlockTableRepository;
import cn.hopever.platform.cms.repository.TemplateResourceTableRepository;
import cn.hopever.platform.cms.repository.TemplateTableRepository;
import cn.hopever.platform.cms.service.TemplateTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("templateTableService")
@Transactional
public class TemplateTableServiceImpl implements TemplateTableService {
    Logger logger = LoggerFactory.getLogger(TemplateTableServiceImpl.class);

    @Autowired
    private TemplateTableRepository templateTableRepository;
    @Autowired
    private TemplateBlockTableRepository templateBlockTableRepository;
    @Autowired
    private TemplateResourceTableRepository templateResourceTableRepository;
    @Autowired
    private CustomTemplateTableRepository customTemplateTableRepository;

    //
    @Override
    public Page<TemplateTable> getList( Pageable pageable, Map<String, Object> filterMap) {
        return customTemplateTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public TemplateTable save(TemplateTable templateTable) {
        return templateTableRepository.save(templateTable);
    }

    @Override
    public void delete(Long id) {
        templateTableRepository.delete(id);
    }

    @Override
    public void deleteTemplateBlockByTemplate(TemplateTable templateTable) {
        templateBlockTableRepository.deleteByTemplate(templateTable);
    }

    @Override
    public void deleteTemplateResourceByTemplate(TemplateTable templateTable) {
        templateResourceTableRepository.deleteByTemplate(templateTable);
    }

    @Override
    public TemplateTable get(Long id) {
        return templateTableRepository.findOne(id);
    }

    @Override
    public List<TemplateTable> getListByWebsiteOrNull(WebsiteTable websiteTable) {
        return templateTableRepository.findByWebsiteOrWebsiteIsNull(websiteTable);
    }
}
