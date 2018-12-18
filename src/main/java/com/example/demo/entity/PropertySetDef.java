package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 09:58
 */
@Table(name = "types.PROPERTY_SET_DEF")
@Entity
public @Data class PropertySetDef implements Serializable {

    @Column(name = "id", nullable = false)
    @Id
    // @OneToMany
    private String id;

    @Column(name = "tenantId", nullable = false)
    private String tenantId;

    @Column(name = "psTypeId", nullable = false)
    private String psTypeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "version")
    private String  version;

    @Column(name = "scope", nullable = false)
    private String scope;

    @Column(name = "created")
    private String created;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "lastUpd")
    private String lastUpd;

    @Column(name = "eTag")
    private String eTag;

}
