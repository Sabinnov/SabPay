/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User_Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karimata
 */
@Repository
public interface UserRoleRepository extends CrudRepository <User_Role, Long>{

    @Query(value ="INSERT INTO user_role(user_id,role_id) VALUES (?1, ?2)",nativeQuery = true)
    public void mySave(@Param("user")Integer user, @Param("role")Integer role);

    
   
}
