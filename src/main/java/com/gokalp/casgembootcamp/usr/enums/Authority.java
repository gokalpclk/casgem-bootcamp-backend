package com.gokalp.casgembootcamp.usr.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Gokalp on 28.12.2022
 * @project casgem-bootcamp
 */
@Getter
public enum Authority implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_EMPLOYEE,
    ROLE_READONLY;

    @Override
    public String getAuthority() {
        return name();
    }
}