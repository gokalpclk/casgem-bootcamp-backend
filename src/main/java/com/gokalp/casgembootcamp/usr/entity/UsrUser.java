package com.gokalp.casgembootcamp.usr.entity;

import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import com.gokalp.casgembootcamp.usr.enums.Authority;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
//@Inheritance(strategy = InheritanceType.JOINED)
public class UsrUser extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "national_identity")
	private String nationalIdentity;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "authority")
	@Enumerated(EnumType.STRING)
	private Authority authority;

}
