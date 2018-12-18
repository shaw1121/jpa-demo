package com.example.demo.repository;

import com.example.demo.entity.PropertySetPropertyDef;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PropSetPropDefRepository
        extends CrudRepository<PropertySetPropertyDef, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.PROPERTY_SET_PROPERTY_DEF where psId = ?1", nativeQuery = true)
    int deleteByPsId(String id);
}
