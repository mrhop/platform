package cn.hopever.platform.cms.repository.impl;

import cn.hopever.platform.cms.domain.NewsTable;
import cn.hopever.platform.cms.repository.CustomNewsTableRepository;
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
@Repository("customNewsTableRepository")
public class CustomNewsTableRepositoryImpl extends SimpleJpaRepository<NewsTable, Long> implements CustomNewsTableRepository {

    private final EntityManager entityManager;

    public CustomNewsTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(NewsTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<NewsTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<NewsTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<NewsTable>() {
            public Predicate toPredicate(Root<NewsTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        Predicate predicateInternal = null;
                        if (key.equals("newsType")) {
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
