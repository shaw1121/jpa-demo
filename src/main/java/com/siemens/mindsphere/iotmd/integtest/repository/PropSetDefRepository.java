package com.siemens.mindsphere.iotmd.integtest.repository;

import com.siemens.mindsphere.iotmd.integtest.dao.PropertySetDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PropSetDefRepository extends JpaRepository<PropertySetDef, String> {

    @Modifying
    @Transactional
    int deleteByPsTypeId(String psTypeId);

}
