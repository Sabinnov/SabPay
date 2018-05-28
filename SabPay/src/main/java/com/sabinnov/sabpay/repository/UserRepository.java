package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select COUNT(u) from User u where u.telephone = :telephone")
    int findByTelephone(@Param("telephone")  String telephone);
    
  
    //-----------------Affectation d'un role a l'utilisateur-----------------------
     
   
     @Query("select u.id from User u where u.telephone = :telephone")
    int findByTelephoneId(@Param("telephone")  String telephone);
    
     //----------------Mise a jour active pour indiquer que l'utilisateur est connecte-----
  
    @Modifying
    @Transactional
    @Query("update User u SET u.active = 1 WHERE u.telephone =:telephone")
    int Connecter(@Param("telephone")  String telephone);
    
     //----------------Verifivcation de l'identiter de l'utilisateur-----
     @Query("select COUNT(u) from User u where u.telephone = :telephone and u.password = :password")
    int isUserVerify(@Param("telephone")  String telephone,@Param("password")  String password);

}