package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.BlockTable;
import cn.hopever.platform.cms.repository.BlockTableRepository;
import cn.hopever.platform.cms.repository.CustomBlockTableRepository;
import cn.hopever.platform.cms.service.BlockTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("blockTableService")
@Transactional
public class BlockTableServiceImpl implements BlockTableService {
    Logger logger = LoggerFactory.getLogger(BlockTableServiceImpl.class);

    @Autowired
    private BlockTableRepository blockTableRepository;
    @Autowired
    private CustomBlockTableRepository customBlockTableRepository;

    @Override
    public Page<BlockTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customBlockTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public BlockTable save(BlockTable blockTable) {
        return blockTableRepository.save(blockTable);
    }

    @Override
    public void delete(Long id) {
        blockTableRepository.delete(id);
    }

    @Override
    public BlockTable get(Long id) {
        return blockTableRepository.findOne(id);
    }
}
