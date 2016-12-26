package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import cn.hopever.platform.cms.service.FileLibraryTypeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fileLibraryTypeTableService")
@Transactional
public class FileLibraryTypeTableServiceImpl implements FileLibraryTypeTableService {
    Logger logger = LoggerFactory.getLogger(FileLibraryTypeTableServiceImpl.class);

    @Override
    public List<FileLibraryTypeTable> getListByWebsite(long websiteId) {
        return null;
    }

    @Override
    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
