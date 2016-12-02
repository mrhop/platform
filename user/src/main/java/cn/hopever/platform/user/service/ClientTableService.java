package cn.hopever.platform.user.service;

import cn.hopever.platform.user.domain.ClientTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
//need to use this as the userdetailservice,then return the true things there
// then implict
// then password
// then client then consider about the different system to use,like cms crm,etc
public interface ClientTableService extends ClientDetailsService {

    public ClientDetails loadClientByClientId(String clientId);

    public ClientTable save(ClientTable client);
    public void delete(ClientTable client);
    public ClientTable getById(Long id);
    public Iterable<ClientTable> getAll();
    public List<ClientTable> getByUserName(String userName);
    public List<ClientTable> getByUserId(Long userId);

    public ClientTable getByClientId(String clientId);
    public List<ClientTable> getByIds(List<Object> ids);
    public Page<ClientTable> getList(Pageable pageable, Map<String, Object> filterMap);


}
