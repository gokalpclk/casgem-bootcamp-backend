package com.gokalp.casgembootcamp.emp.entity;

import com.gokalp.casgembootcamp.emp.enums.Positions;
import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
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
@Table(name = "employee")
public class EmpEmployee extends UsrUser {

	@Enumerated(EnumType.STRING)
	private Positions position;

}
