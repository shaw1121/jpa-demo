package com.siemens.mindsphere.iotmd.integtest.repository;

import com.siemens.mindsphere.iotmd.integtest.dao.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface TenantRepository extends JpaRepository<Tenant, String> {

    @Modifying
    @Transactional
    void deleteByIdentityId(String identityId);

}
