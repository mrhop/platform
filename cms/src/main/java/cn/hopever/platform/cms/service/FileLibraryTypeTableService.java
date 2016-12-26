package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface FileLibraryTypeTableService {

    public List<FileLibraryTypeTable> getListByWebsite(long websiteId);

    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable);

    public void delete(Long id);
}
