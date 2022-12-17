package com.gokalp.casgembootcamp.usr.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsrPasswordChangeRequest {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

}
