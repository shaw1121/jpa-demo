package com.example.demo.entity;

/**
 * @author Zhang Xiao
 * @date 12/14/2018 16:02
 * refer: https://www.jianshu.com/p/515d7a92d79a
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * This tells Hibernate to make a table out of this class
 * 此类用于向mysql生成表
 *
 * @author yclimb
 * @date 2018/2/26
 */
@Table(name="users")
@Entity
public @Data class User {

    public User(){

    }

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

}