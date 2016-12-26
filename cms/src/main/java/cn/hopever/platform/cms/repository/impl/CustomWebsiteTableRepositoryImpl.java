package cn.hopever.platform.cms.repository.impl;

import cn.hopever.platform.cms.domain.WebsiteTable;
import cn.hopever.platform.cms.repository.CustomWebsiteTableRepository;
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
@Repository("customWebsiteTableRepository")
public class CustomWebsiteTableRepositoryImpl  extends SimpleJpaRepository<WebsiteTable, Long> implements CustomWebsiteTableRepository {

    private final EntityManager entityManager;

    public CustomWebsiteTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(WebsiteTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<WebsiteTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<WebsiteTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<WebsiteTable>() {
            public Predicate toPredicate(Root<WebsiteTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        Predicate predicateInternal = null;
                        if(key.equals("enabled")){
                            predicateInternal = builder.equal(root.get(key), mapFilter.get(key));
                        }else{
                            predicateInternal =  builder.like(root.get(key), "%" + mapFilter.get(key) + "%");
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
