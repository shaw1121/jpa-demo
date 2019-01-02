package com.siemens.mindsphere.iotmd.integtest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ENTITY_TYPE_PROPERTY_DEF")
@Getter
@Setter
public class EntityTypePropertyDef {

    @EmbeddedId
    private EntityTypePropertyDefId entityTypePropertyDefId;

    @Column
    private String category;

    @Column
    private  String psTypeId;

    @Column
    private String propertyDataType;

    @Column
    private String propertyUnitOfMeasure;

    @Column
    private Integer propertyLength;

    @Column
    private String searchable;

    @Column
    private Integer version;

    @Column
    private String description;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "etId", insertable = false, updatable = false)
    private EntityTypeDef entityTypeDef;

}
