package com.animal.adoption.security;

import com.animal.adoption.domain.User;
import com.animal.adoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class LoginUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(username);
//        return new org.springframework.security.core.userdetails.User(
//                username,
//                user.getPassword(),
//        		AuthorityUtils.createAuthorityList(user.getRole()));
        System.out.println("User found from database, username=" + user.getUsername());
        return new LoginUser(user);
    }

}
