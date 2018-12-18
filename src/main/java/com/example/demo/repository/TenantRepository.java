package com.example.demo.repository;

import com.example.demo.entity.Tenant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhang Xiao
 * @date 12/15/2018 16:39
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from tenants.tenant where identity_id = ?1", nativeQuery = true)
    void deleteByIdentityId(String identityId);

    @Query(value = "select id from tenants.tenant where identity_id = ?1", nativeQuery = true)
    String getIdByIdentityId(String identityId);

}

