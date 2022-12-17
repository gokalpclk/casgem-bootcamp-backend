package com.gokalp.casgembootcamp.gen.exception;

import com.gokalp.casgembootcamp.gen.exceptions.GenBusinessException;
import com.gokalp.casgembootcamp.gen.exceptions.ItemNotFoundException;
import com.gokalp.casgembootcamp.gen.exceptions.ValidationException;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@RestController
@ControllerAdvice
public class GenCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest) {

		Date errorDate = new Date();
		String message = ex.getMessage();
		String description = webRequest.getDescription(false);

		GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);
		RestResponse<Object> restResponse = RestResponse.error(genExceptionResponse);
		restResponse.setMessage(message);
		return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleAllGenBusinessException(GenBusinessException ex, WebRequest webRequest) {
		Date errorDate = new Date();
		String message = ex.getBaseErrorMessage().getMessage();
		String description = webRequest.getDescription(false);

		GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);
		RestResponse<GenExceptionResponse> restResponse = RestResponse.error(genExceptionResponse);
		restResponse.setMessage(message);
		return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest) {

		Date errorDate = new Date();
		String message = ex.getBaseErrorMessage().getMessage();
		String description = webRequest.getDescription(false);

		GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);
		RestResponse<Object> restResponse = RestResponse.error(genExceptionResponse);
		restResponse.setMessage(message);
		return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleIValidationException(ValidationException ex, WebRequest webRequest) {

		Date errorDate = new Date();
		String message = ex.getBaseErrorMessage().getMessage();
		String description = webRequest.getDescription(false);

		GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);
		RestResponse<Object> restResponse = RestResponse.error(genExceptionResponse);
		restResponse.setMessage(message);
		return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
	}

}
