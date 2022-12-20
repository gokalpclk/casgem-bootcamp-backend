package com.gokalp.casgembootcamp.apo.entity;

import com.gokalp.casgembootcamp.apo.enums.ApoStates;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
public class ApoApplication extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private AppApplicant applicant;

	@ManyToOne
	@JoinColumn(name = "bootcamp_id")
	private BooBootcamp bootcamp;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private ApoStates state;

}
