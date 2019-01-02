package com.siemens.mindsphere.iotmd.integtest.repository;

import com.siemens.mindsphere.iotmd.integtest.dao.EntityTypePropertyDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EntityTypePropertyDefRepository extends JpaRepository<EntityTypePropertyDef, String> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.ENTITY_TYPE_PROPERTY_DEF where etId = ?1", nativeQuery = true)
    int deleteByEtId(String id);
}
