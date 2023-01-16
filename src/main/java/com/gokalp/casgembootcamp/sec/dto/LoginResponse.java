package com.gokalp.casgembootcamp.sec.dto;

import com.gokalp.casgembootcamp.sec.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 16.01.2023
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private boolean status;
    private String token;
    private Authority role;
}
