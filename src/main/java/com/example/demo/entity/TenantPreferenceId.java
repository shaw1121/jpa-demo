package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author Zhang Xiao
 * @date 12/17/2018 09:39
 */
public @Data class TenantPreferenceId implements Serializable {

    private static final long serialVersionUID = 1968759340951706352L;
    private String tenantId;
    private String name;
    private String type;

    public TenantPreferenceId(){

    }

    public TenantPreferenceId(String tenantId, String name, String type){
        this.tenantId = tenantId;
        this.name = name;
        this.type = type;
    }

}
