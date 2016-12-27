package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.ResourceTable;
import cn.hopever.platform.cms.repository.CustomResourceTableRepository;
import cn.hopever.platform.cms.repository.ResourceTableRepository;
import cn.hopever.platform.cms.service.ResourceTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("resourceTableService")
@Transactional
public class ResourceTableServiceImpl implements ResourceTableService {
    Logger logger = LoggerFactory.getLogger(ResourceTableServiceImpl.class);

    @Autowired
    private ResourceTableRepository resourceTableRepository;
    @Autowired
    private CustomResourceTableRepository customResourceTableRepository;

    @Override
    public Page<ResourceTable> getList( Pageable pageable, Map<String, Object> filterMap) {
        return customResourceTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public ResourceTable save(ResourceTable resourceTable) {
        return this.resourceTableRepository.save(resourceTable);
    }

    @Override
    public void delete(Long id) {
        this.resourceTableRepository.delete(id);
    }

    @Override
    public ResourceTable get(Long id) {
        return this.resourceTableRepository.findOne(id);
    }
}
