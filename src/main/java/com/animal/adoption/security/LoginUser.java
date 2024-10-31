package com.animal.adoption.security;

import com.animal.adoption.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class LoginUser implements UserDetails {
    private User user;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public LoginUser(User user) {
        this.user = user;
        this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Account is not expired, expired cannot be verified
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Account is not locked, locked cannot be verified
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Credentials are not expired, expired cannot be verified
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * User is enabled, enabled cannot be verified
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
