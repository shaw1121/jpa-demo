package com.siemens.mindsphere.iotmd.integtest.dao;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Table(name = "ENTITIES")
@Getter
@Setter
public class Entity {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String tenant;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String parent;

    @Column(nullable = false)
    private String tableName;

    @Column(nullable = false)
    private String type;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant markForDeleteTime;

    @Column
    private String timezone;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant created;

    @Column
    private String createdBy;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant lastUpd;

    @Column
    private String lastUpdBy;

    @Column(name = "$subtenant")
    private String subtenant;
}
