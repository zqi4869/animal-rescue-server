package com.animal.adoption.controller;

import com.animal.adoption.domain.User;
import com.animal.adoption.service.UserService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public RestResult getInfo(String username) {
        return RestResult.success(userService.findUserByUsername(username));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public RestResult save(@RequestBody User user) {
        return RestResult.success(userService.save(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "";
    }
}
