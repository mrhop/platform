package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.ResourceTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ResourceTableService {
    //存储资源，删除资源，资源列表，资源的下载，资源的备份，最多5个，用在修改的部分，资源的回退

    public Page<ResourceTable> getList(Principal principal, Pageable pageable, Map<String, Object> filterMap);

    public ResourceTable save(ResourceTable resourceTable);

    public void delete(Long id);

    public ResourceTable get(Long id);
}
