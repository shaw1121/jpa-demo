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
public class PropertySetPropertyDefId implements Serializable {

    @Column(insertable = false, updatable = false)
    private String psId;

    @Column
    private String name;

}
