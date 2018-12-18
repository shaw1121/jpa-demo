package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 16:03
 */
public @Data class EntityTypePropertyDefId implements Serializable {

    private static final long serialVersionUID = 1968759340951706352L;
    private String etId;
    private String name;

    public EntityTypePropertyDefId(){}

    public EntityTypePropertyDefId(String etId, String name){
        this.etId = etId;
        this.name = name;
    }
}
