package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email")  String email);

}