package com.animal.adoption.controller;

import com.animal.adoption.domain.User;
import com.animal.adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> findAll() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user.getId().toHexString());
        }
        return all;
    }

    @GetMapping("/all1")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> findAll1() {
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "";
    }
}
