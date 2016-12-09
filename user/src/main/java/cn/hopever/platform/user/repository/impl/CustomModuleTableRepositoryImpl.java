package cn.hopever.platform.user.repository.impl;

import cn.hopever.platform.user.domain.ClientTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.repository.CustomModuleTableRepository;
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
@Repository("customModuleTableRepository")
public class CustomModuleTableRepositoryImpl extends SimpleJpaRepository<ModuleTable, Long> implements CustomModuleTableRepository {

    private final EntityManager entityManager;

    public CustomModuleTableRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(ModuleTable.class, entityManager), entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<ModuleTable> findByFilters(Map<String, Object> mapFilter, Pageable pageable, ClientTable userAdminClient) {
        return super.findAll(filterConditions1(mapFilter,userAdminClient), pageable);
    }

    //do this filter
    private Specification<ModuleTable> filterConditions1(Map<String, Object> mapFilter,ClientTable userAdminClient) {
        //实现这个
        return new Specification<ModuleTable>() {
            public Predicate toPredicate(Root<ModuleTable> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Predicate predicateReturn = null;
                predicateReturn = builder.notEqual(root.get("client"), userAdminClient);
                //query.distinct(true);
                if (mapFilter != null && mapFilter.size() > 0) {
                    for (String key : mapFilter.keySet()) {
                        if (mapFilter.get(key) != null) {
                            if (key.equals("moduleName")) {
                                predicateReturn = builder.and(predicateReturn, builder.like(root.get(key), "%" + mapFilter.get(key) + "%"));
                            } else {
                                //需要针对filter来进行值得获取和填充
                                predicateReturn = builder.and(predicateReturn, builder.equal(root.get(key), mapFilter.get(key)));
                            }
                        }
                    }
                }
                return predicateReturn;
            }
        };
    }
}
