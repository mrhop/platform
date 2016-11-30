package cn.hopever.platform.user.repository.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.repository.CustomClientTableRepository;
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
import java.util.Map;

/**
 * Created by Donghui Huo on 2016/11/30.
 */
@Repository("customClientTableRepository")
public class CustomClientTableRepositoryImpl extends SimpleJpaRepository<ClientTable, Long> implements CustomClientTableRepository {

    private final EntityManager entityManager;

    public CustomClientTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ClientTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<ClientTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        if (mapFilter == null || mapFilter.isEmpty()) {
            return super.findAll(pageable);
        } else {
            return super.findAll(filterConditions1(mapFilter), pageable);
        }
    }

    private Specification<ClientTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<ClientTable>() {
            public Predicate toPredicate(Root<ClientTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                for (String key : mapFilter.keySet()) {
                    if (mapFilter.get(key) != null) {
                        if (predicateReturn == null) {
                            predicateReturn = builder.like(root.get(key), "%" + mapFilter.get(key) + "%");
                        } else {
                            predicateReturn = builder.and(predicateReturn, builder.like(root.get(key), "%" + mapFilter.get(key) + "%"));
                        }
                    }
                }
                return predicateReturn;
            }
        };
    }
}
