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
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="user_id",nullable = false, insertable = false, updatable = false)
     @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user_id;

    public User_Role(Role role_id, User user_id) {
        this.role_id = role_id;
        this.user_id = user_id;
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
    public Role getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the user_id
     */
    public User getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
    
     @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", role_id='" + role_id + '\'' +               
                '}';
    }
    
}
