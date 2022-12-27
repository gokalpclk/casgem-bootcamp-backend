package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gokalp on 26.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@Builder
public class JwtUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUserDetails create(UsrUser user){
        List<SimpleGrantedAuthority> grantedAuthorityList = user.getRoles().stream().map((role -> new SimpleGrantedAuthority(role.getName()))).collect(Collectors.toList());

        JwtUserDetails jwtUserDetails = JwtUserDetails.builder()
                .id(user.getId())
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(grantedAuthorityList)
                .build();
        return jwtUserDetails;
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
