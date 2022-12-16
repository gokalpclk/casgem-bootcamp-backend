package com.gokalp.casgembootcamp.gen.exceptions;

import com.gokalp.casgembootcamp.gen.enums.BaseErrorMessage;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
public class ValidationException extends GenBusinessException{
    public ValidationException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
