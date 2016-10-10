package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ClientTable;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
//need to use this as the userdetailservice,then return the true things there
// then implict
// then password
// then client then consider about the different system to use,like cms crm,etc
public interface ClientTableService extends ClientDetailsService {
    public ClientTable save(ClientTable client);

}
