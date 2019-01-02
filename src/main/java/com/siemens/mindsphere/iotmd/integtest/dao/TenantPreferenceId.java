package com.siemens.mindsphere.iotmd.integtest.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class TenantPreferenceId implements Serializable {

    @Column(name = "tenant_id", nullable = false, insertable = false, updatable = false)
    private String tenantId;

    @Column
    private String name;

    @Column
    private Integer type;

}
