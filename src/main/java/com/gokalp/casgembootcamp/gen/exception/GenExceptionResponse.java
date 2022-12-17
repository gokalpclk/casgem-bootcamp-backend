package com.gokalp.casgembootcamp.gen.exception;

import lombok.*;

import java.util.Date;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@Data
@AllArgsConstructor
public class GenExceptionResponse {
    private Date errorDate;
    private String message;
    private String description;
}
