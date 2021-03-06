package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import cn.hopever.platform.cms.repository.CustomFileLibraryTableRepository;
import cn.hopever.platform.cms.repository.FileLibraryTableRepository;
import cn.hopever.platform.cms.service.FileLibraryTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("fileLibraryTableService")
@Transactional
public class FileLibraryTableServiceImpl implements FileLibraryTableService {
    Logger logger = LoggerFactory.getLogger(FileLibraryTableServiceImpl.class);

    @Autowired
    private FileLibraryTableRepository fileLibraryTableRepository;
    @Autowired
    private CustomFileLibraryTableRepository customFileLibraryTableRepository;

    @Override
    public Page<FileLibraryTable> getList(Pageable pageable, Map<String, Object> filterMap) {
        return customFileLibraryTableRepository.findByFilters(filterMap, pageable);
    }

    @Override
    public List<FileLibraryTable> getListByType(Map<String, Object> filterMap) {
        return customFileLibraryTableRepository.findByTypeAndFilters(filterMap);
    }

    @Override
    public FileLibraryTable save(FileLibraryTable fileLibraryTable) {
        return fileLibraryTableRepository.save(fileLibraryTable);
    }

    @Override
    public void delete(Long id) {
        fileLibraryTableRepository.delete(id);
    }

    @Override
    public FileLibraryTable get(Long id) {
        return fileLibraryTableRepository.findOne(id);
    }
}
