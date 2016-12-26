package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.OperationTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/12/26.
 */
public interface CustomOperationTableRepository {

    public Page<OperationTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable);

}
