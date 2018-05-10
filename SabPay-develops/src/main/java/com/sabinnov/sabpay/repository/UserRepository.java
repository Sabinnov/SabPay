package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;


public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email")  String email);

    @Query("select u from User u")
    Stream<User> streamAllUsers();

    @Query("select u from User u")
    List<User> findAllUsers();
}