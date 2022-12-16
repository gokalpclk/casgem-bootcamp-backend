package com.gokalp.casgembootcamp.ins.dto.responses;

import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserGetAllResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsInstructorGetAllResponse extends UsrUserGetAllResponse {
    private String companyName;
}
