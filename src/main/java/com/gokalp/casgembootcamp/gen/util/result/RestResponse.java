package com.gokalp.casgembootcamp.gen.util.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> implements Serializable {

	private T data;

	private Date responseDate;

	private boolean isSuccess;

	private String message;

	public RestResponse(T data, boolean isSuccess) {
		this.data = data;
		this.isSuccess = isSuccess;
		responseDate = new Date();
	}

	public static <T> RestResponse<T> of(T t) {
		return new RestResponse<>(t, true);
	}

	public static <T> RestResponse<T> error(T t) {
		return new RestResponse<>(t, false);
	}

	public static <T> RestResponse<T> empty() {
		return new RestResponse<>(null, false);
	}

}
