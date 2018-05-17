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
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email")  String email);
    
     //----------------Mise a jour active pour indiquer aue l'utilisateur est connecte-----
  
    @Modifying
    @Transactional
    @Query("update User u SET u.active = 1 WHERE u.email =:email")
    int Connecter(@Param("email")  String email);
    
     //----------------Verifivcation de l'identiter de l'utilisateur-----
     @Query("select COUNT(u) from User u where u.email = :email and u.password = :password")
    int isUserVerify(@Param("email")  String email,@Param("password")  String password);

}