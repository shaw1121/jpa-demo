package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 10:23
 */
public @Data class PropertySetPropertyDefId implements Serializable {

    private static final long serialVersionUID = 1968759340951706352L;
    private String psId;
    private String name;

    public PropertySetPropertyDefId(String psId, String name){
        this.psId = psId;
        this.name = name;
    }

    public PropertySetPropertyDefId(){

    }

}
