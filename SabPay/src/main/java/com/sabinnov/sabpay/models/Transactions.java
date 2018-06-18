/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author karimata
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "transactions")
public class Transactions implements Serializable {
    @Id
    @Column(name = "id_transaction")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer id;

    
    @Column(name = "date")
    @ApiModelProperty(notes = "transaction date", required = true)
    private String date;
    
    @Column(name = "status")
    @ApiModelProperty(notes = "Transaction status", required = true)
    private String status;
    
    @Column(name = "operateur")
    @ApiModelProperty(notes = " Opeateur", required = true)
    private String operateur;
    
    @ManyToOne
    @JoinColumn(name = "user_id_fk")	
    @ApiModelProperty(notes = "User id send", required = true)
    private User user_id_fk;
      
    @Column(name = "numero_telephone_client_facturer")
    @ApiModelProperty(notes = "User telephone received", required = true)
    private String telephone;

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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the operateur
     */
    public String getOperateur() {
        return operateur;
    }

    /**
     * @param operateur the operateur to set
     */
    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

  

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the user_id_fk
     */
    public User getUser_id_fk() {
        return user_id_fk;
    }

    /**
     * @param user_id_fk the user_id_fk to set
     */
    public void setUser_id_fk(User user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

   
    
}
