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
@Table(name = "PROPERTY_SET_PROPERTY_DEF", schema = "types")
@Getter
@Setter
public class PropertySetPropertyDef {

    @EmbeddedId
    private PropertySetPropertyDefId propertySetPropertyDefId;

    @Column
    private String description;

    @Column(nullable = false)
    private String dataType;

    @Column
    private String unitOfMeasure;

    @Column
    private Integer length;

    @Column
    private Integer version;

    @Column
    private String qualityCode;

    @Column
    private String searchable;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "psId", insertable = false, updatable = false)
    private PropertySetDef propertySetDef;
}
