package com.gokalp.casgembootcamp.apo.dto.requests;

import com.gokalp.casgembootcamp.apo.enums.ApoStates;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApoApplicationUpdateRequest {
    private Long id;

    private Long applicantId;

    private Long bootcampId;

    private ApoStates state;
}
