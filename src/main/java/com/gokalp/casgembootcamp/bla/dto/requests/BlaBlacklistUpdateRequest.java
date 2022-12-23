package com.gokalp.casgembootcamp.bla.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gokalp on 23.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlaBlacklistUpdateRequest {
    private Long appApplicantId;
    private String reason;
}
