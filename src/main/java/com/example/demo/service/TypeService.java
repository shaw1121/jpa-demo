package com.example.demo.service;

import com.example.demo.entity.EntityTypePropertyDef;
import com.example.demo.repository.EntityTypeDefRepository;
import com.example.demo.repository.EntityTypePropertyDefRepository;
import com.example.demo.repository.PropSetDefRepository;
import com.example.demo.repository.PropSetPropDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 11:06
 */
@Service
public class TypeService {

    @Autowired
    PropSetDefRepository propSetDefRepository;

    @Autowired
    PropSetPropDefRepository propSetPropDefRepository;

    @Autowired
    EntityTypeDefRepository entityTypeDefRepository;

    @Autowired
    EntityTypePropertyDefRepository entityTypePropertyDefRepository;

    @Transactional
    public void deletePsByPsTypeId(String psTypeId) {
        propSetDefRepository.deleteByPsTypeId(psTypeId);
    }

    public String getIdByPsTypeId(String psTypeId) {
        return propSetDefRepository.getIdByPsTypeId(psTypeId);
    }

    @Transactional
    public void deletePropertyByPsId(String id) {
        propSetPropDefRepository.deleteByPsId(id);
    }

    public void deleteEtByEtId(String etTypeId) {
        entityTypeDefRepository.deleteByEtTypeId(etTypeId);
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
