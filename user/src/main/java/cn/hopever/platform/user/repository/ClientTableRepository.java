package cn.hopever.platform.user.repository;

import cn.hopever.platform.user.domain.ClientTable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Donghui Huo on 2016/8/30.
 */
public interface ClientTableRepository extends CrudRepository<ClientTable, Integer> {
    public ClientTable findOneByClientId(String clientId);
}
