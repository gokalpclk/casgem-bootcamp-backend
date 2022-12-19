package com.gokalp.casgembootcamp.apo.dto.responses;

import com.gokalp.casgembootcamp.apo.enums.ApoStates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApoApplicationCreateResponse {
    private Long id;
    private Long bootcampId;
    private Long applicantId;
    private ApoStates state;
}
