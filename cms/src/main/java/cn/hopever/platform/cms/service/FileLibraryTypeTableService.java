package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface FileLibraryTypeTableService {

    public List<FileLibraryTypeTable> getList(Map<String, Object> filterMap);

    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable);

    public void delete(Long id);
}
