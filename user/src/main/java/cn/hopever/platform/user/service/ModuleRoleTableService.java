package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ModuleRoleTable;

import java.util.List;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleRoleTableService {
    public List<ModuleRoleTable> getByClients(List<Object> clientIds);
    public List<ModuleRoleTable> getByUserId(Long userId);
}
