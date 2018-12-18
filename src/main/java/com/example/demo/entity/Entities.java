package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 16:48
 */
@Entity
@Table(name = "ENTITIES")
public @Data class Entities implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "tenant", nullable = false)
    private String tenant;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "parent")
    private String parent;

    @Column(name = "tableName", nullable = false)
    private String tableName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "markForDeleteTime")
    private String markForDeleteTime;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "created")
    private String created;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "lastUpd")
    private String lastUpd;

    @Column(name = "lastUpdBy")
    private String lastUpdBy;

    @Column(name = "$subtenant")
    private String $subtenant;

}
