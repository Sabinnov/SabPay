/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.repository;

import com.sabinnov.sabpay.models.DetailUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karimata
 */
@Repository
public interface detailUserRepository extends CrudRepository<DetailUser, Long>{
    
}
