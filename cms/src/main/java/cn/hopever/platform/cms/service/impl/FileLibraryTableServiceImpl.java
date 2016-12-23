package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import cn.hopever.platform.cms.service.FileLibraryTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("fileLibraryTableService")
@Transactional
public class FileLibraryTableServiceImpl implements FileLibraryTableService {
    Logger logger = LoggerFactory.getLogger(FileLibraryTableServiceImpl.class);

    @Override
    public Page<FileLibraryTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return null;
    }

    @Override
    public FileLibraryTable save(FileLibraryTable fileLibraryTable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
