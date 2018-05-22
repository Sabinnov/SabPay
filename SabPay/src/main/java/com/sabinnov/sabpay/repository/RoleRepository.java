/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.repository;

import com.sabinnov.sabpay.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karimata
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    
  
}
