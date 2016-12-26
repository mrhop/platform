package cn.hopever.platform.cms.repository.impl;

import cn.hopever.platform.cms.domain.FileLibraryTable;
import cn.hopever.platform.cms.repository.CustomFileLibraryTableRepository;
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
@Repository("customFileLibraryTableRepository")
public class CustomFileLibraryTableRepositoryImpl extends SimpleJpaRepository<FileLibraryTable, Long> implements CustomFileLibraryTableRepository {

    private final EntityManager entityManager;

    public CustomFileLibraryTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(FileLibraryTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<FileLibraryTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<FileLibraryTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<FileLibraryTable>() {
            public Predicate toPredicate(Root<FileLibraryTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                query.distinct(true);
                if (mapFilter != null) {
                    for (String key : mapFilter.keySet()) {
                        Predicate predicateInternal = null;
                        if (key.equals("isPublished") || key.equals("fileLibraryType")) {
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
