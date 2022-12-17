package com.gokalp.casgembootcamp.gen.exceptions;

import com.gokalp.casgembootcamp.gen.enums.BaseErrorMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@Data
public class GenBusinessException extends RuntimeException {

	private final BaseErrorMessage baseErrorMessage;

}
