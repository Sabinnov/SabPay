/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.service;

import com.sabinnov.sabpay.repository.TransactionRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author karimata
 */

@Service
public class TransactionService {
    
    private TransactionRepository transactionRepository;
    
     public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
