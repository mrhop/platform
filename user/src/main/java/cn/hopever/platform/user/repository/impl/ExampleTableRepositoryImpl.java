package cn.hopever.platform.user.repository.impl;

import cn.hopever.platform.user.domain.ExampleTable;
import cn.hopever.platform.user.repository.ExampleTableRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Donghui Huo on 2016/9/2.
 */
@Repository
public class ExampleTableRepositoryImpl implements ExampleTableRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Iterable<ExampleTable> filterByUserName(String username) {
        return  em.createQuery(
                "SELECT c FROM ExampleTable c WHERE c.userName LIKE :userName")
                .setParameter("userName", "%"+username+"%")
                .getResultList();
    }
}
