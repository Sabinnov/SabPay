/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user_role")
public class User_Role implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer id;
    
    
    
    @Column(name = "role_id")
    @ApiModelProperty(notes = "role_id", required = true)
    private int role_id;
    
    @Column(name = "user_id")
    @ApiModelProperty(notes = "user_id", required = true)
    private int user_id;
    
 

    public User_Role(int role_id, int user_id) {
        this.role_id = role_id;
        this.user_id = user_id;
    }
    
    
    
    
     @Override
    public String toString() {
        return "User_Role{" +
                "id=" + getId() +
                ", user_id='" + getUser_id() + '\'' +
                ", role_id='" + getRole_id() + '\'' +               
                '}';
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the role_id
     */
    public int getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

 
    
}
