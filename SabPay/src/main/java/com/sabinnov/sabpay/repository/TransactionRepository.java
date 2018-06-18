/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.repository;

import com.sabinnov.sabpay.models.Transactions;
import java.util.List;

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
public interface TransactionRepository extends CrudRepository<Transactions, Long>{

   // List<Transaction> findByTelephone(@Param("telephone")  String telephone);
    
    @Modifying
    @Transactional 
    @Query("SELECT t FROM Transactions t LEFT JOIN User u on t.user_id_fk = u.id WHERE u.telephone =:telephone")
    public List findByTelephone(@Param("telephone")  String telephone);
    
}
