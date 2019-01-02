package com.siemens.mindsphere.iotmd.integtest.dao;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tenant")
@Entity
@Getter
@Setter
public class Tenant {

    @Id
    @Column(nullable = false)
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
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant created;

    @Column(name = "created_by")
    private String createdBy;

    @Convert(converter = TimestampAttributeConverter.class)
    @Column(name = "last_upd")
    private Instant lastUpd;

    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @Column
    private Integer eTag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tenant", fetch = FetchType.EAGER)
    private Set<TenantPreference> tenantPreferences = new HashSet<>();

}
