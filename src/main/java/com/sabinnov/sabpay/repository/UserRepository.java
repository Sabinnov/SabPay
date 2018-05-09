package com.sabinnov.sabpay.repository;


import com.sabinnov.sabpay.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Long> {
    User findByUserId(long userId);
}
