package cn.hopever.platform.cms.service.impl;

import cn.hopever.platform.cms.domain.FileLibraryTypeTable;
import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.FileLibraryTypeTableRepository;
import cn.hopever.platform.cms.service.FileLibraryTypeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fileLibraryTypeTableService")
@Transactional
public class FileLibraryTypeTableServiceImpl implements FileLibraryTypeTableService {
    Logger logger = LoggerFactory.getLogger(FileLibraryTypeTableServiceImpl.class);

    @Autowired
    private FileLibraryTypeTableRepository fileLibraryTypeTableRepository;

    @Override
    public List<FileLibraryTypeTable> getListByWebsites(List<WebsiteTable> list) {
        return fileLibraryTypeTableRepository.findByWebsiteIn(list);
    }

    @Override
    public FileLibraryTypeTable save(FileLibraryTypeTable fileLibraryTypeTable) {
        return fileLibraryTypeTableRepository.save(fileLibraryTypeTable);
    }

    @Override
    public void delete(Long id) {
        fileLibraryTypeTableRepository.delete(id);
    }

    @Override
    public FileLibraryTypeTable get(Long id) {
        return fileLibraryTypeTableRepository.findOne(id);
    }
}
