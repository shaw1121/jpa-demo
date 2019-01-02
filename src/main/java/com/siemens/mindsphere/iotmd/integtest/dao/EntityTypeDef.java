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

@Entity
@Table(name = "ENTITY_TYPE_DEF")
@Getter
@Setter
public class EntityTypeDef {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String tenantId;

    @Column(nullable = false)
    private String etTypeId;

    @Column(nullable = false)
    private  String name;

    @Column
    private String description;

    @Column
    private String superType;

    @Column
    private Integer version;

    @Column
    private String scope;

    @Column(nullable = false)
    private String tableName;

    @Column(nullable = false)
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant created;

    @Column
    private String createdBy;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant lastUpd;

    @Column
    private String lastUpdBy;

    @Column
    private String eTag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityTypeDef", fetch = FetchType.EAGER)
    private Set<EntityTypeDef> entityTypeDefs = new HashSet<>();
}
