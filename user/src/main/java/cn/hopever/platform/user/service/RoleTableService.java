package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.RoleTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
//need to use this as the userdetailservice,then return the true things there
// then implict
// then password
// then client then consider about the different system to use,like cms crm,etc
public interface RoleTableService {
    public RoleTable save(RoleTable role);

    public RoleTable update(RoleTable role);

    public List<RoleTable> getList(String authority);

}
