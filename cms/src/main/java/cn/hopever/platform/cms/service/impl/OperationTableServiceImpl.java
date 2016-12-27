package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.OperationTable;
import cn.hopever.platform.cms.repository.CustomOperationTableRepository;
import cn.hopever.platform.cms.repository.OperationTableRepository;
import cn.hopever.platform.cms.service.OperationTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("operationTableService")
@Transactional
public class OperationTableServiceImpl implements OperationTableService {
    Logger logger = LoggerFactory.getLogger(OperationTableServiceImpl.class);
    @Autowired
    private OperationTableRepository operationTableRepository;
    @Autowired
    private CustomOperationTableRepository customOperationTableRepository;

    @Override
    public Page<OperationTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customOperationTableRepository.findByFilters(filterMap,pageable);
    }

    @Override
    public OperationTable save(OperationTable operationTable) {
        return operationTableRepository.save(operationTable);
    }

    @Override
    public void delete(Long id) {
        operationTableRepository.delete(id);
    }

    @Override
    public OperationTable get(Long id) {
        return operationTableRepository.findOne(id);
    }
}
