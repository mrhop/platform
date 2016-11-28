package cn.hopever.platform.user.repository.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.RoleTable;
import cn.hopever.platform.user.domain.UserTable;
import cn.hopever.platform.user.repository.CustomUserTableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/11/2.
 */
@Repository("customUserTableRepository")
public class CustomUserTableRepositoryImpl extends SimpleJpaRepository<UserTable, Long> implements CustomUserTableRepository {

    private final EntityManager entityManager;

    public CustomUserTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(UserTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<UserTable> findByUsernameNotAndFilters(String username, Map mapFilter, Pageable pageable) {
        //采用Specification的方式整合条件处理，并调用super的getall的方式
        return super.findAll(filterConditions1(username, mapFilter), pageable);
    }


    private Specification<UserTable> filterConditions1(String username, Map<String, Object> mapFilter) {
        return new Specification<UserTable>() {
            public Predicate toPredicate(Root<UserTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = builder.notEqual(root.get("username"), username);
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        if (mapFilter.get(key) != null) {
                            predicateReturn = builder.and(predicateReturn, builder.like(root.get(key), "%" + mapFilter.get(key) + "%"));
                        }
                    }
                }
                return predicateReturn;
            }
        };
    }


    @Override
    public Page<UserTable> findByCreateUserAndAuthoritiesInAndClientsInAndFilters(UserTable userTable, Collection<RoleTable> authorities1, Collection<RoleTable> authorities2, Collection<ClientTable> clients, Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions2(userTable, authorities1, authorities2, clients, mapFilter), pageable);
    }

    private Specification<UserTable> filterConditions2(UserTable userTable, Collection<RoleTable> authorities1, Collection<RoleTable> authorities2, Collection<ClientTable> clients, Map<String, Object> mapFilter) {
        return new Specification<UserTable>() {
            public Predicate toPredicate(Root<UserTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null && mapFilter.size() > 0) {
                    for (String key : mapFilter.keySet()) {
                        if (mapFilter.get(key) != null) {
                            predicateReturn = builder.and(predicateReturn, builder.like(root.get(key), "%" + mapFilter.get(key) + "%"));
                        }
                    }
                }
                if (predicateReturn == null) {
                    predicateReturn = builder.and(builder.or(builder.and(builder.equal(root.get("createUser"), userTable), root.join("authorities").in(authorities1)), root.join("authorities").in(authorities2)), root.join("clients").in(clients));
                } else {
                    predicateReturn = builder.and(predicateReturn, builder.or(root.join("authorities").in(authorities1), builder.and(builder.equal(root.get("createUser"), userTable), root.join("authorities").in(authorities2))), root.join("clients").in(clients));
                }
                return predicateReturn;
            }
        };
    }
}
