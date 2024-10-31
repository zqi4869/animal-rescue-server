package com.animal.adoption.controller;

import com.animal.adoption.domain.User;
import com.animal.adoption.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        List<User> all = userRepository.findAll();
    }

}
