package com.animal.adoption.controller;

import com.animal.adoption.domain.User;
import com.animal.adoption.security.LoginUser;
import com.animal.adoption.service.UserService;
import com.animal.adoption.utils.JwtUtil;
import com.animal.adoption.utils.RestResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;
    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public RestResult login(@RequestBody User user, HttpServletResponse response) {
        Authentication authResult;
        try {
            authResult = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            LoginUser loginUser = (LoginUser) authResult.getPrincipal();

            if(!Objects.equals(user.getRole(), loginUser.getUser().getRole())) {
                return RestResult.error("Username or password is incorrect");
            }

            for (GrantedAuthority authority : loginUser.getAuthorities()) {
                System.out.println("role: " + authority.getAuthority());
            }

            String token = JwtUtil.generateToken(loginUser.getUsername(), loginUser.getUser().getRole());
            response.addHeader(JwtUtil.TOKEN_HEADER, "Bearer " + token);
            System.out.println("token: " + token);

            return RestResult.success(token);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof BadCredentialsException) {
                System.out.println("username or password is incorrect");
                return RestResult.error("username or password is incorrect");
            }
        }
        return RestResult.error("login failed");
    }

}
