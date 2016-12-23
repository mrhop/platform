package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.NavigateTable;
import cn.hopever.platform.cms.service.NavigateTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("navigateTableService")
@Transactional
public class NavigateTableServiceImpl implements NavigateTableService {
    Logger logger = LoggerFactory.getLogger(NavigateTableServiceImpl.class);

    @Override
    public Page<NavigateTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public NavigateTable save(NavigateTable navigateTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
