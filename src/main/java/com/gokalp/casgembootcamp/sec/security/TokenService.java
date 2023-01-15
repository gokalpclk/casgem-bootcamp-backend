package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;

/**
 * @author Gokalp on 15.01.2023
 * @project casgem-bootcamp
 */
public interface TokenService {
    String createToken(UsrUser user);

    UsrUser getUser(Object source);
}
