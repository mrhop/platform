package cn.hopever.platform.cms.repository;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/12/26.
 */
public interface CustomFileLibraryTypeTableRepository {

    public Page<FileLibraryTypeTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable);

}
