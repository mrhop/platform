package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.OperationTable;
import cn.hopever.platform.cms.service.OperationTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("operationTableService")
@Transactional
public class OperationTableServiceImpl implements OperationTableService {
    Logger logger = LoggerFactory.getLogger(OperationTableServiceImpl.class);

    @Override
    public Page<OperationTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public OperationTable save(OperationTable operationTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
