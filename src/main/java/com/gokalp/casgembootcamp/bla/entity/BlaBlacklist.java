package com.gokalp.casgembootcamp.bla.entity;

import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blacklist")
public class BlaBlacklist extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "reason")
	private String reason;

	@OneToOne
	@JoinColumn(name = "applicant_id")
	private AppApplicant applicant;

}
