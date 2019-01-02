package com.siemens.mindsphere.iotmd.integtest.service;

import com.siemens.mindsphere.iotmd.integtest.repository.EntityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @Autowired
    EntityRepository entityRepository;

    public List<String> getEntityIdByEtTypeId(String etTypeId) {
        return entityRepository.getIdByEtTypeId(etTypeId);
    }

    public void deleteEntityByEtTypeId (String etTypeId) {
        entityRepository.deleteEntityByEtTypeId(etTypeId);
    }

    public void deleteEntityByEntityId(String entityId) {
        entityRepository.deleteEntityById(entityId);
    }
}
