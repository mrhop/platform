package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ModuleTable;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ModuleTableService {

    public Iterable<ModuleTable> getListByClientAndAuthorityAndUser(String clientId, String authority, String username);
    public Iterable<ModuleTable> getAll();

}
