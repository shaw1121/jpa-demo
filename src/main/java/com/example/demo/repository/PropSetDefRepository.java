package com.example.demo.repository;

import com.example.demo.entity.PropertySetDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 10:49
 */
public interface PropSetDefRepository extends JpaRepository<PropertySetDef, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.PROPERTY_SET_DEF where psTypeId = ?1", nativeQuery = true)
    int deleteByPsTypeId(String psTypeId);

    @Query(value = "select id from types.PROPERTY_SET_DEF where psTypeId = ?1", nativeQuery = true)
    String getIdByPsTypeId(String psTypeId);
}
