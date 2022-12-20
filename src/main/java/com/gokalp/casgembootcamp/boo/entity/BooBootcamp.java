package com.gokalp.casgembootcamp.boo.entity;

import com.gokalp.casgembootcamp.apo.entity.ApoApplication;
import com.gokalp.casgembootcamp.boo.enums.BooStates;
import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamp")
public class BooBootcamp extends BaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private BooStates state;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private InsInstructor instructor;

	@OneToMany(mappedBy = "bootcamp")
	private List<ApoApplication> applications;

}
