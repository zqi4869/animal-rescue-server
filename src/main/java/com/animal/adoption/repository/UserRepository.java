package com.animal.adoption.repository;

import com.animal.adoption.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findUserByUsername(String username);
}
