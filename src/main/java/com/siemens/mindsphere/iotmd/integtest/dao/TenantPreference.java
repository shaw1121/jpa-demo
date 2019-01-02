package com.siemens.mindsphere.iotmd.integtest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tenant_preference")
@Entity
@Getter
@Setter
public class TenantPreference {

    @EmbeddedId
    private TenantPreferenceId tenantPreferenceId;

    @Column(nullable = false)
    private String value;

    @Column
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_upd")
    @Convert(converter = TimestampAttributeConverter.class)
    private Instant lastUpd;

    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id", insertable = false, updatable = false)
    private Tenant tenant;

}
