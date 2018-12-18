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
 * @date 12/16/2018 22:22
 */
@Table(name = "tenant_preference"/*, uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "name", "type"})}*/)
@Entity
@IdClass(TenantPreferenceId.class)
public @Data class TenantPreference implements Serializable {

    @Column(name = "tenant_id", nullable = false)
    @Id
    private String tenantId;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private String value;

    @Id
    @Column(name = "type")
    private String type;

    @Column(name = "created")
    private String created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_upd")
    private String lastUpd;

    @Column(name = "last_upd_by")
    private String lastUpdBy;
}
