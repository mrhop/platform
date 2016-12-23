package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.ResourceTable;
import cn.hopever.platform.cms.service.ResourceTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("resourceTableService")
@Transactional
public class ResourceTableServiceImpl implements ResourceTableService {
    Logger logger = LoggerFactory.getLogger(ResourceTableServiceImpl.class);

    @Override
    public Page<ResourceTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public ResourceTable save(ResourceTable resourceTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
