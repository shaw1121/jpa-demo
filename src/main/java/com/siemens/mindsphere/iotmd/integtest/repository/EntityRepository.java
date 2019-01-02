package com.siemens.mindsphere.iotmd.integtest.repository;

import com.siemens.mindsphere.iotmd.integtest.dao.Entity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EntityRepository extends JpaRepository<Entity, String> {

    @Modifying
    @Transactional
    @Query(value = "delete from entities.ENTITIES where type = ?1", nativeQuery = true)
    int deleteEntityByEtTypeId(String etTypeId);

    @Modifying
    @Transactional
    @Query(value = "delete from entities.ENTITIES where id = ?1", nativeQuery = true)
    int deleteEntityById(String entityId);

    @Query(value = "select id from entities.ENTITIES where type = ?1", nativeQuery = true)
    List<String> getIdByEtTypeId(String etTypeId);
}
