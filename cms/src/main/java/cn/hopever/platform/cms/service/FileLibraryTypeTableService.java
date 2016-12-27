package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface FileLibraryTypeTableService {

    public List<FileLibraryTypeTable> getListByWebsites(List<WebsiteTable> list);

    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable);

    public void delete(Long id);

    public FileLibraryTypeTable get(Long id);
}
