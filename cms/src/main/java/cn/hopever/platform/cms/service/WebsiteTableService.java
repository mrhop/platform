package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.WebsiteTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface WebsiteTableService {
    //获取列表
    //修改website website 不可用 也是一个选项
    //新增
    //获取单个
    //删除website 【所有关联都会删除】
    //当用户是管理员权限时，可以指定
    // 相关的其他都是和website 做关联，而不在website处做管理
    //website的管理，只能管理员可见并处理

    public Page<WebsiteTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public WebsiteTable save(WebsiteTable websiteTable);

    public void delete(Long id);

    public WebsiteTable get(Long id);

    public Iterable<WebsiteTable> getList(Principal principal);

    public boolean validatePermission(Principal principal, WebsiteTable websiteTable);

    public List<WebsiteTable> getWebsiteAsFilter(Principal principal,String id);

    public Iterable<WebsiteTable> getWebsiteAsFilter(Principal principal);

}
