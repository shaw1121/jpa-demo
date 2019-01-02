package com.siemens.mindsphere.iotmd.integtest.repository;

import com.siemens.mindsphere.iotmd.integtest.dao.EntityTypeDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EntityTypeDefRepository extends JpaRepository<EntityTypeDef, String> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    int deleteByEtTypeId(String etTypeId);

    @Query(value = "select id from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    String getIdByEtTypeId(String etTypeId);

    @Query(value = "select tableName from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    String getTableNameByEtTypeId(String etTypeId);
}
