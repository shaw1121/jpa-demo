package com.example.demo.service;

import com.example.demo.repository.TenantPreferenceRepository;
import com.example.demo.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhang Xiao
 * @date 12/16/2018 23:41
 */
@Service
public class TenantService {

    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    TenantPreferenceRepository tenantPreferenceRepository;

    @Transactional
    public void deleteTenantByIdentityId(String identityId){
        tenantRepository.deleteByIdentityId(identityId);
    }

    public String getIdByIdentityId(String identityId){
        return tenantRepository.getIdByIdentityId(identityId);
    }

    @Transactional
    public void deleteTenantByTenantId(String id){
        tenantPreferenceRepository.deleteTenantByTenantId(id);
    }
}
