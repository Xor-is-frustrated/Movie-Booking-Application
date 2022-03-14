package com.personal.project.model;

import com.personal.project.model.data.FieldErrorData;

import java.util.Collection;

public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;

	private ApiStatus status;
	private Collection<FieldErrorData> errors;

	public ApiException(ApiStatus status, String message, Collection<FieldErrorData> errors) {
		super(message);
		this.status = status;
		this.errors = errors;
	}

	public ApiException(ApiStatus status, String message, Throwable t) {
		super(message, t);
		this.status = status;
	}

	public ApiException(ApiStatus status, String message) {
		super(message);
		this.status = status;
	}

	public ApiException(ApiStatus status, Throwable t) {
		super(t);
		this.status = status;
	}

	public ApiException(ApiStatus status) {
		super();
		this.status = status;
	}

	public ApiStatus getStatus() {
		return status;
	}

	public Collection<FieldErrorData> getErrors() {
		return errors;
	}

	public void setErrors(Collection<FieldErrorData> errors) {
		this.errors = errors;
	}

}
