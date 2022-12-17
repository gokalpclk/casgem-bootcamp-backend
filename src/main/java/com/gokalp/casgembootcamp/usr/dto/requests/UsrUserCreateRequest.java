package com.gokalp.casgembootcamp.usr.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsrUserCreateRequest {

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String nationalIdentity;

	private String email;

	private String password;

	private String confirmPassword;

}
