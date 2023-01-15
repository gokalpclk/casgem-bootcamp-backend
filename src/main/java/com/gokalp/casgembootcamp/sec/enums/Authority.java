package com.gokalp.casgembootcamp.sec.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Gokalp on 26.12.2022
 * @project casgem-bootcamp
 */

public enum Authority implements GrantedAuthority {
    ADMIN,
    EMPLOYEE,
    INSTRUCTOR,
    APPLICANTS;

    @Override
    public String getAuthority() {
        return name();
    }
}
