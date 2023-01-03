package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import com.gokalp.casgembootcamp.usr.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Gokalp on 3.01.2023
 * @project casgem-bootcamp
 */
@Builder

//@AllArgsConstructor
//@RequiredArgsConstructor
public class JwtUserDetails implements UserDetails {
//    private final UsrUser user;



    public Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public static JwtUserDetails create(UsrUser user){
        JwtUserDetails jwtUserDetails = JwtUserDetails.builder()
                .id(user.getId())
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(List.of(Authority.valueOf(user.getAuthority().toString())))
                .build();
        return jwtUserDetails;
    }
    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
