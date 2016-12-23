package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.OperationTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface OperationTableService {

    public Page<OperationTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public OperationTable save(OperationTable operationTable);

    public void delete(Long id);
}
