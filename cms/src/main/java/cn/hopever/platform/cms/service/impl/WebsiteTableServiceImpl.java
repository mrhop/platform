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
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
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

    @Override
    public WebsiteTable get(Long id) {
        return websiteTableRepository.findOne(id);
    }

    @Override
    public List<WebsiteTable> getList(Principal principal) {
        String username = principal.getName();
        username = "[" + username + "]";
        return this.websiteTableRepository.findByRelatedUsernamesLike(username);
    }

    @Override
    public boolean validatePermission(Principal principal, WebsiteTable websiteTable) {
        String authority = ((OAuth2Authentication) principal).getAuthorities().iterator().next().getAuthority();
        if ("ROLE_super_admin".equals(authority) || "ROLE_admin".equals(authority)) {
            return true;
        } else {
            boolean validated = false;
            List<WebsiteTable> list = this.getList(principal);
            if (websiteTable != null && list != null && list.size() > 0 && list.contains(websiteTable)) {
                validated = true;
            }
            return validated;
        }
    }
}
