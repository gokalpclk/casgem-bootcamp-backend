package com.gokalp.casgembootcamp.apo.dto.requests;

import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApoApplicationCreateRequest {
    private Long applicant;
    private Long bootcamp;

}
