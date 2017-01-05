package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NavigateTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomNavigateTableRepository;
import cn.hopever.platform.cms.repository.NavigateTableRepository;
import cn.hopever.platform.cms.service.NavigateTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("navigateTableService")
@Transactional
public class NavigateTableServiceImpl implements NavigateTableService {
    Logger logger = LoggerFactory.getLogger(NavigateTableServiceImpl.class);

    @Autowired
    private NavigateTableRepository navigateTableRepository;
    @Autowired
    private CustomNavigateTableRepository customNavigateTableRepository;

    @Override
    public Page<NavigateTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customNavigateTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public NavigateTable save(NavigateTable navigateTable) {
        return navigateTableRepository.save(navigateTable);
    }

    @Override
    public void delete(Long id) {
        navigateTableRepository.delete(id);
    }

    @Override
    public NavigateTable get(Long id) {
        return navigateTableRepository.findOne(id);
    }

    @Override
    public List<NavigateTable> getListByWebsite(WebsiteTable websiteTable) {
        return navigateTableRepository.findByWebsiteAndParentIsNullAndSort(websiteTable,new Sort(Sort.Direction.ASC,"orderNum"));
    }
}
