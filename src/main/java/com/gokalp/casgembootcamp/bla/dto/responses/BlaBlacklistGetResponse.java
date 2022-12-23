package com.gokalp.casgembootcamp.bla.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Gokalp on 23.12.2022
 * @project casgem-bootcamp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlaBlacklistGetResponse {
    private Long id;
    private Long appApplicantId;
    private Date date;
    private String reason;
}
