package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ClientRoleTable;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ClientRoleTableService {

    public GrantedAuthority loadByAuthority(String authority);

    public ClientRoleTable getByAuthority(String authority);
}
