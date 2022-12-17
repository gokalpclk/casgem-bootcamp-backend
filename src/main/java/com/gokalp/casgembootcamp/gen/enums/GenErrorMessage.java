package com.gokalp.casgembootcamp.gen.enums;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
public enum GenErrorMessage implements BaseErrorMessage {

	ITEM_NOTFOUND("Item not found!"), DATE_COULD_NOT_BE_CONVERTED("Date could not be converted."),
	VALUE_CANNOT_BE_NEGATIVE("Value cannot be negative"), PARAMETER_CANNOT_BE_NULL("Parameter cannot be null"),;

	private String message;

	GenErrorMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
