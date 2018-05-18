package com.sabinnov.sabpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

   
   private String telephone;
    private String password;

  public UserNotFoundException(String exception) {
    super(exception);
  }


    public UserNotFoundException(String telephone, String password) {
        super(String.format(" not found with "+ telephone+" "+password));
        this.telephone = telephone;
        this.password = password;
     
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

   
    

}