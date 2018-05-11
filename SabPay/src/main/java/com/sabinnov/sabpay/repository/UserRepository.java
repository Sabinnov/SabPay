package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(@Param("email")  String email);

    // cette methode retour un stream de java 8 qui permettra de faire des filtres si besoin
    //@Query("select u from User u")
    //Stream<User> streamAllUsers();

    //List<User> findAllUsers();
}