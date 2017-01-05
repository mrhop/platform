package cn.hopever.platform.cms.repository.impl;

import cn.hopever.platform.cms.domain.NavigateTable;
import cn.hopever.platform.cms.repository.CustomNavigateTableRepository;
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
 * Created by Donghui Huo on 2016/12/26.
 */
@Repository("customNavigateTableRepository")
public class CustomNavigateTableRepositoryImpl extends SimpleJpaRepository<NavigateTable, Long> implements CustomNavigateTableRepository {

    private final EntityManager entityManager;

    public CustomNavigateTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(NavigateTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<NavigateTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<NavigateTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<NavigateTable>() {
            public Predicate toPredicate(Root<NavigateTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        Predicate predicateInternal = null;
                        if (key.equals("parent") || key.equals("website")) {
                            predicateInternal = builder.equal(root.get(key), mapFilter.get(key));
                        } else {
                            predicateInternal = builder.like(root.get(key), "%" + mapFilter.get(key) + "%");
                        }
                        if (predicateReturn == null) {
                            predicateReturn = predicateInternal;
                        } else {
                            predicateReturn = builder.and(predicateReturn, predicateInternal);
                        }
                    }
                }
                return predicateReturn;
            }
        };
    }
}
