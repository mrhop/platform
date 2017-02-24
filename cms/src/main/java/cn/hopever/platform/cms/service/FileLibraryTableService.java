package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface FileLibraryTableService {

    //主要是根据filetype 来获取合适的列表，【需要根据websiteid考虑】
    public Page<FileLibraryTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public List<FileLibraryTable> getListByType( Map<String, Object> filterMap);

    public FileLibraryTable save(FileLibraryTable fileLibraryTable);

    public void delete(Long id);

    public FileLibraryTable get(Long id);
}
