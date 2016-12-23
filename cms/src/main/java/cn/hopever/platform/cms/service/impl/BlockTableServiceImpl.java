package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.BlockTable;
import cn.hopever.platform.cms.service.BlockTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("blockTableService")
@Transactional
public class BlockTableServiceImpl implements BlockTableService {
    Logger logger = LoggerFactory.getLogger(BlockTableServiceImpl.class);

    @Override
    public Page<BlockTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public BlockTable save(BlockTable blockTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
