package com.example.demo.repository;

import com.example.demo.entity.Entities;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EntitiesRepository extends CrudRepository<Entities, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from types.ENTITY_TYPE_DEF where etTypeId = ?1", nativeQuery = true)
    int deleteByEtTypeId(String etTypeId);


}
