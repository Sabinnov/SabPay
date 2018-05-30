/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author karimata
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "detail_user")
public class DetailUser implements Serializable {
    @Id
    @Column(name = "id_detail")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer id;

    
    @Column(name = "type")
    @ApiModelProperty(notes = "Detail User type", required = true)
    private String type;
    
    @Column(name = "email")
    @ApiModelProperty(notes = "Detail User email", required = true)
    private String email;
    
   
    @Column(name = "user_id")
    @ApiModelProperty(notes = "Detail User idUser", required = true)
    private int user_id;

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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    
    
      public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +                
                
                '}';
    }
    
}
