package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.ModuleTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleTableRepository extends PagingAndSortingRepository<ModuleTable, Long> {
    public ModuleTable findOneByModuleName(String moduleName);
    public List<ModuleTable> findDistinctByModuleNameLike(String moduleName, Pageable pageable);

    //如果是common-user，要根据user，然后指向到module-role，然后根据这个获取到的modulelist，然后根据modulelist中包含的modulerole，进行处理并过滤，然后返回，并筛出二级的包含，并写入到父module中
    public List<ModuleTable> findDistinctByParentAndClient(ModuleTable parent,ClientTable client);
    public List<ModuleTable> findDistinctByParentAndClientAndModuleName(ModuleTable parent,ClientTable client,String moduleName);
    public List<ModuleTable> findDistinctByParentAndClientAndModuleNameLike(ModuleTable parent,ClientTable client,String moduleName);
    public List<ModuleTable> findDistinctByParentAndClientAndAuthoritiesIn(ModuleTable parent, ClientTable client, Collection<ModuleRoleTable> authorities);

}
