package com.gokalp.casgembootcamp.usr.entity;

import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import com.gokalp.casgembootcamp.sec.entity.SecRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
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

	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
	)
	private List<SecRole> roles;

}
