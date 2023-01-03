package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import com.gokalp.casgembootcamp.usr.services.entityServices.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 3.01.2023
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UsrUserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsrUser user = userEntityService.findByEmail(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        UsrUser user = userEntityService.getByIdWithControl(id);
        return JwtUserDetails.create(user);
    }
}
