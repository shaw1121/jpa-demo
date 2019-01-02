package com.siemens.mindsphere.iotmd.integtest.service;

import com.siemens.mindsphere.iotmd.integtest.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    TenantRepository tenantRepository;

    public void deleteTenantByIdentityId(String identityId){
        tenantRepository.deleteByIdentityId(identityId);
    }

}
