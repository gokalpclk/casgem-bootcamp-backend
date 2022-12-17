package com.gokalp.casgembootcamp.gen.exceptions;

import com.gokalp.casgembootcamp.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends GenBusinessException {

	public ItemNotFoundException(BaseErrorMessage message) {
		super(message);
	}

}
