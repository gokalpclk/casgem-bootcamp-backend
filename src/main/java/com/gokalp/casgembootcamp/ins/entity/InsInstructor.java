package com.gokalp.casgembootcamp.ins.entity;

import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructor")
public class InsInstructor extends UsrUser {
    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<BooBootcamp> bootcamps;
}
