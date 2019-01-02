package com.siemens.mindsphere.iotmd.integtest.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@RequiredArgsConstructor
public class EntityTypePropertyDefId implements Serializable {

    @Column(insertable = false, updatable = false)
    private String etId;

    @Column
    private String name;

}
