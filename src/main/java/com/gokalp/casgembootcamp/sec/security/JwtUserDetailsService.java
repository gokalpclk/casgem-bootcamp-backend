package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.sec.security.JwtUserDetails;
import com.gokalp.casgembootcamp.usr.dao.UsrUserDao;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Gokalp on 26.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UsrUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsrUser user = userDao.findByNationalIdentity(username);
        JwtUserDetails userDetails = JwtUserDetails.create(user);
        return userDetails;
    }

    public UserDetails loadUserById(Long id){
        UsrUser user = userDao.findById(id).get();
        JwtUserDetails userDetails = JwtUserDetails.create(user);
        return userDetails;
    }
}
