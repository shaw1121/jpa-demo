package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 15:45
 */
@Entity
@Table(name = "entity_type_def")
public @Data class EntityTypeDef  implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "tenantId", nullable = false)
    private String tenantId;

    @Column(name = "etTypeId", nullable = false)
    private String etTypeId;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "description")
    private String description;

    @Column(name = "superType")
    private String superType;

    @Column(name = "version")
    private String version;

    @Column(name = "scope")
    private String scope;

    @Column(name = "tableName", nullable = false)
    private String tableName;

    @Column(name = "created", nullable = false)
    private String created;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "lastUpd")
    private String lastUpd;

    @Column(name = "lastUpdBy")
    private String lastUpdBy;

    @Column(name = "eTag")
    private String eTag;
}
