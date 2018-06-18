/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabinnov.sabpay.controller;

import static com.sabinnov.sabpay.controller.UserController.LOGGER;
import com.sabinnov.sabpay.exceptions.UserNotFoundException;
import com.sabinnov.sabpay.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import javax.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karimata
 */
@RestController
@RequestMapping("/sab")
public class TransactionController {
    
    private TransactionService transactionService;   
    
    @Autowired
    public void setTransactionService(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    
    @RequestMapping(value = "/api/transaction/",method = RequestMethod.POST, produces = "application/json")
   @ApiOperation(
            value = "History transactionController",
            notes = "history transaction, specify telephone number",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List< Transaction> historyTransaction(@RequestParam(value = "telephone", required = true) String telephone) {
        
            return transactionService.historyTransaction(telephone);
      
    }
    
    
}
