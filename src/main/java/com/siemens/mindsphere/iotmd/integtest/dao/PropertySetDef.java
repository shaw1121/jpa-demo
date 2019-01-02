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

@Table(name = "property_set_def", schema = "types")
@Entity
@Getter
@Setter
public class PropertySetDef {

    @Column(nullable = false)
    @Id
    private String id;

    @Column(nullable = false)
    private String tenantId;

    @Column(nullable = false)
    private String psTypeId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private String category;

    @Column
    private Integer version;

    @Column(nullable = false)
    private String scope;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant created;

    @Column
    private String createdBy;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant lastUpd;

    @Column
    private String eTag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "propertySetDef", fetch = FetchType.EAGER)
    private Set<PropertySetPropertyDef> propertySetPropertyDefs = new HashSet<>();

}
