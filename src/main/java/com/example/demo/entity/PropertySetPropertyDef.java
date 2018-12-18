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
 * @date 12/17/2018 10:14
 */
@Entity
@Table(name = "PROPERTY_SET_PROPERTY_DEF")
@IdClass(PropertySetPropertyDefId.class)
public @Data class PropertySetPropertyDef implements Serializable {

    @Id
    @Column(name = "psId", nullable = false)
    // @ManyToOne
    private String psId;

    @Id
    // @ManyToOne
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dataType", nullable = false)
    private String dataType;

    @Column(name = "unitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "length")
    private String length;

    @Column(name = "version")
    private String version;

    @Column(name = "qualityCode")
    private String qualityCode;

    @Column(name = "searchable")
    private String searchable;
}
