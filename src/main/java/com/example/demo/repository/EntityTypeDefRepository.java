package com.example.demo.repository;

import com.example.demo.entity.EntityTypeDef;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.SunHints.Value;

public interface EntityTypeDefRepository extends CrudRepository<EntityTypeDef, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    int deleteByEtTypeId(String etTypeId);

    @Query(value = "select id from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    String getIdByEtTypeId(String etTypeId);

    @Query(value = "select tableName from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    String getTableNameByEtTypeId(String etTypeId);
}
