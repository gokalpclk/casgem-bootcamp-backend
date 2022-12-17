package com.gokalp.casgembootcamp.usr.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsrUserUpdateResponse {

	private Long id;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String nationalIdentity;

	private String email;

	private String password;

	private String confirmPassword;

}
