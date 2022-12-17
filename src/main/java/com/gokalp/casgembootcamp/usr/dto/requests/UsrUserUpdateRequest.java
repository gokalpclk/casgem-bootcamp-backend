package com.gokalp.casgembootcamp.usr.dto.requests;

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
@AllArgsConstructor
@NoArgsConstructor
public class UsrUserUpdateRequest {

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String nationalIdentity;

	private String email;

	private String password;

	private String confirmPassword;

}
