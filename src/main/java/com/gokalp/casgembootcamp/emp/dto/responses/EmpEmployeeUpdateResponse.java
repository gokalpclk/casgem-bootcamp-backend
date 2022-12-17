package com.gokalp.casgembootcamp.emp.dto.responses;

import com.gokalp.casgembootcamp.emp.enums.Positions;
import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserUpdateResponse;
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
public class EmpEmployeeUpdateResponse extends UsrUserUpdateResponse {

	private Positions position;

}
