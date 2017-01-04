package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface FileLibraryTypeTableService {

    public Page<FileLibraryTypeTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public List<FileLibraryTypeTable> getListByWebsites(List<WebsiteTable> list);

    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable);

    public void delete(Long id);

    public FileLibraryTypeTable get(Long id);
}
