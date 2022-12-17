package com.gokalp.casgembootcamp.emp.dto.requests;

import com.gokalp.casgembootcamp.emp.enums.Positions;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
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
@AllArgsConstructor
@NoArgsConstructor
public class EmpEmployeeCreateRequest extends UsrUserCreateRequest {

	private Positions positions;

}
