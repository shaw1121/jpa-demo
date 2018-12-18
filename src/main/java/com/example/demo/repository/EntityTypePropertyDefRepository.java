package com.example.demo.repository;

import com.example.demo.entity.EntityTypePropertyDef;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EntityTypePropertyDefRepository extends CrudRepository<EntityTypePropertyDef, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.ENTITY_TYPE_PROPERTY_DEF where etId = ?1", nativeQuery = true)
    int deleteByEtId(String id);
}
