package com.gokalp.casgembootcamp.app.entity;

import com.gokalp.casgembootcamp.apo.entity.ApoApplications;
import com.gokalp.casgembootcamp.bla.entity.BlaBlacklist;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicant")
public class AppApplicant extends UsrUser {

	@Column(name = "about")
	private String about;

	@OneToMany(mappedBy = "applicant")
	private List<ApoApplications> applications;

	@OneToOne(mappedBy = "applicant")
	private BlaBlacklist blacklist;

}
