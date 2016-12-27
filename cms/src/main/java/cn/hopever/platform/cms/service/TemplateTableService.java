package cn.hopever.platform.cms.service;

import cn.hopever.platform.cms.domain.TemplateTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface TemplateTableService {
    //获取列表
    //修改和新增
    //删除
    //为其指定website ，注意这个website的列表的可用性
    //创建时，是否也需要指定website
    public Page<TemplateTable> getList(Pageable pageable, Map<String, Object> filterMap);

    public TemplateTable save(TemplateTable templateTable);

    public void delete(Long id);

    public TemplateTable get(Long id);

}
