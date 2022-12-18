package com.gokalp.casgembootcamp.app.dto.responses;

import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserGetResponse;
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

public class AppApplicantGetResponse extends UsrUserGetResponse {
    private String about;
}
