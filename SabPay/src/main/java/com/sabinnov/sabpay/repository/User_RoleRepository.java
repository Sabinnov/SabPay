/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User_Role;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karimata
 */
@Repository
public interface User_RoleRepository extends CrudRepository <User_Role, Long>{

    @Modifying
    
    @Query(value ="INSERT INTO user_role(role_id,user_id) VALUES (:user,:role)",nativeQuery = true)
    public User_Role mySave(@Param("user")Integer user, @Param("role")Integer role);

    
    /*
    @Modifying
    @Transactional 
    @Query("INSERT INTO user_role(role_id,user_id) VALUES (2,1)")
           
     public int executeAddRoleUser();
     */
    
}
