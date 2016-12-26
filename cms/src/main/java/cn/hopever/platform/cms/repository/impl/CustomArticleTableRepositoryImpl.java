package cn.hopever.platform.cms.repository.impl;

import cn.hopever.platform.cms.domain.ArticleTable;
import cn.hopever.platform.cms.repository.CustomArticleTableRepository;
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
@Repository("customArticleTableRepository")
public class CustomArticleTableRepositoryImpl extends SimpleJpaRepository<ArticleTable, Long> implements CustomArticleTableRepository {

    private final EntityManager entityManager;

    public CustomArticleTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ArticleTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<ArticleTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<ArticleTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<ArticleTable>() {
            public Predicate toPredicate(Root<ArticleTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        Predicate predicateInternal = null;
                        if (key.equals("isPublished")) {
                            predicateInternal = builder.equal(root.get(key), mapFilter.get(key));
                        } else if (key.equals("website")) {
                            predicateInternal = root.join("website").in(mapFilter.get(key));
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
