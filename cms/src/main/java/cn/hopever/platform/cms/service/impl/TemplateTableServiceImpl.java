package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.TemplateTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomTemplateTableRepository;
import cn.hopever.platform.cms.repository.TemplateTableRepository;
import cn.hopever.platform.cms.repository.WebsiteTableRepository;
import cn.hopever.platform.cms.service.TemplateTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("templateTableService")
@Transactional
public class TemplateTableServiceImpl implements TemplateTableService {
    Logger logger = LoggerFactory.getLogger(TemplateTableServiceImpl.class);

    @Autowired
    private WebsiteTableRepository websiteTableRepository;
    @Autowired
    private TemplateTableRepository templateTableRepository;
    @Autowired
    private CustomTemplateTableRepository customTemplateTableRepository;

    //
    @Override
    public Page<TemplateTable> getList(Principal principal, Pageable pageable, Map<String, Object> filterMap) {
        if (filterMap.get("website") != null) {
            List<WebsiteTable> list = new ArrayList<>();
            list.add(websiteTableRepository.findOne(Long.valueOf(filterMap.get("website").toString())));
            filterMap.put("website", list);
        } else {
            String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
            if ("ROLE_common_user".equals(authority)) {
                filterMap.put("website", websiteTableRepository.findByRelatedUsernamesLike("[" + principal.getName() + "]"));
            }
        }
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
    public TemplateTable get(Long id) {
        return templateTableRepository.findOne(id);
    }
}
