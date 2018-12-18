package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 15:55
 */
@Entity
@Table(name = "ENTITY_TYPE_PROPERTY_DEF")
@IdClass(EntityTypePropertyDefId.class)
public @Data class EntityTypePropertyDef implements Serializable {

    @Id
    @Column(name = "etId", nullable = false)
    private String etId;

    @Column(name = "category")
    private String category;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "psTypeId")
    private  String psTypeId;

    @Column(name = "propertyDataType")
    private String propertyDataType;

    @Column(name = "propertyUnitOfMeasure")
    private String propertyUnitOfMeasure;

    @Column(name = "propertyLength")
    private String propertyLength;

    @Column(name = "searchable")
    private String searchable;

    @Column(name = "version")
    private String version;

    @Column(name = "description")
    private String description;

}
