package cn.hopever.platform.user.repository.impl;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.repository.CustomModuleRoleTableRepository;
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
 * Created by Donghui Huo on 2016/12/2.
 */
@Repository("customModuleRoleTableRepository")
public class CustomModuleRoleTableRepositoryImpl extends SimpleJpaRepository<ModuleRoleTable, Long> implements CustomModuleRoleTableRepository {

    private final EntityManager entityManager;

    public CustomModuleRoleTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ModuleRoleTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<ModuleRoleTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable) {
        return super.findAll(filterConditions1(mapFilter), pageable);
    }

    private Specification<ModuleRoleTable> filterConditions1(Map<String, Object> mapFilter) {
        return new Specification<ModuleRoleTable>() {
            public Predicate toPredicate(Root<ModuleRoleTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                //query.distinct(true);
                if (mapFilter != null && mapFilter.size() > 0) {
                    for (String key : mapFilter.keySet()) {
                        if (mapFilter.get(key) != null) {
                            if (predicateReturn != null) {
                                predicateReturn = builder.and(predicateReturn, builder.like(root.get(key), "%" + mapFilter.get(key) + "%"));
                            } else {
                                predicateReturn = builder.like(root.get(key), "%" + mapFilter.get(key) + "%");
                            }
                        }
                    }
                }
                return predicateReturn;
            }
        };
    }
}
