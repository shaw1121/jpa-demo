package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "tenant")
@Entity
public @Data class Tenant {

    public Tenant(){

    }

    @Id
    @Column(nullable = false)
    // @OneToMany(targetEntity = TenantPreference.class)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "ext_id")
    private String extId;

    @Column(nullable = false, name = "identity_id", unique = true)
    private String identityId;

    @Column(nullable = false, name = "type_prefix", unique = true)
    private String typePrefix;

    @Column(name = "storage_prefix", unique = true)
    private String storagePrefix;

    @Column(name = "root_entity_id")
    private String rootEntityId;

    @Column
    private String created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_upd")
    private String lastUpd;

    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @Column
    private String eTag;

}



