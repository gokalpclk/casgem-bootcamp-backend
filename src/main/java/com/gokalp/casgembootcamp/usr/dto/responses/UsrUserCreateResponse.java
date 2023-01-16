package com.gokalp.casgembootcamp.usr.dto.responses;

import com.gokalp.casgembootcamp.sec.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsrUserCreateResponse {

	private Long id;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String nationalIdentity;

	private String email;

	private String password;
	@Enumerated(EnumType.STRING)
	private Authority role;

}
