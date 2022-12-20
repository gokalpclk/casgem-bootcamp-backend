package com.gokalp.casgembootcamp.boo.dto.requests;

import com.gokalp.casgembootcamp.boo.enums.BooStates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Gokalp on 20.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooBootcampCreateRequest {

    private String name;

    private Date startDate;

    private Date endDate;

    private BooStates state;

    private Long instructorId;

}
