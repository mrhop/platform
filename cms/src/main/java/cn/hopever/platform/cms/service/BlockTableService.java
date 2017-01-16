package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.BlockTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface BlockTableService {

    public Page<BlockTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public List<BlockTable> getListByWebsite(Long websiteId);

    public BlockTable save(BlockTable blockTable);

    public void delete(Long id);

    public BlockTable get(Long id);

}
