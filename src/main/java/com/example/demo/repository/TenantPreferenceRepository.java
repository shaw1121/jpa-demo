package com.example.demo.repository;

import com.example.demo.entity.TenantPreference;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 00:10
 */
public interface TenantPreferenceRepository extends CrudRepository<TenantPreference, Long> {

    @Query(value = "delete from tenants.tenant_preference where tenant_id = ?1", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteTenantByTenantId(String id);
}
