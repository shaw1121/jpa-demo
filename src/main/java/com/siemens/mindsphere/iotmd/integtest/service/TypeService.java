package com.siemens.mindsphere.iotmd.integtest.service;

import com.siemens.mindsphere.iotmd.integtest.repository.EntityTypeDefRepository;
import com.siemens.mindsphere.iotmd.integtest.repository.EntityTypePropertyDefRepository;
import com.siemens.mindsphere.iotmd.integtest.repository.PropSetDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Autowired
    PropSetDefRepository propSetDefRepository;

    @Autowired
    EntityTypeDefRepository entityTypeDefRepository;

    @Autowired
    EntityTypePropertyDefRepository entityTypePropertyDefRepository;

    public void deletePsByPsTypeId(String psTypeId) {
        propSetDefRepository.deleteByPsTypeId(psTypeId);
    }




    public String getEtIdByEtTypeId(String etTypeId) {
        return entityTypeDefRepository.getIdByEtTypeId(etTypeId);
    }

    public void deleteEtPropByEtId(String id) {
        entityTypePropertyDefRepository.deleteByEtId(id);
    }

    public String getTableNameByEtTypeId(String etTypeId) {
        return entityTypeDefRepository.getTableNameByEtTypeId(etTypeId);
    }

}
