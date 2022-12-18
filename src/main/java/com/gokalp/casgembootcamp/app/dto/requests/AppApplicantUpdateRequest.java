package com.gokalp.casgembootcamp.app.dto.requests;

import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 18.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppApplicantUpdateRequest extends UsrUserUpdateRequest {
    private String about;
}
