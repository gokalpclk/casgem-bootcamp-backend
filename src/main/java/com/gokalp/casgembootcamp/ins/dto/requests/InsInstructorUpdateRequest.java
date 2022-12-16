package com.gokalp.casgembootcamp.ins.dto.requests;

import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
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
@AllArgsConstructor
@NoArgsConstructor
public class InsInstructorUpdateRequest extends UsrUserCreateRequest {
    private String companyName;
}
