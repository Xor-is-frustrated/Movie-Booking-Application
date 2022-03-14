package com.personal.project.theatre.controller;


import com.personal.project.model.ApiException;
import com.personal.project.model.data.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppRestControllerAdvice {

	@ExceptionHandler(ApiException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorData handle(ApiException e) {
		ErrorData data = new ErrorData();
		data.setMessage(e.getMessage());
		return data;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorData handle(Throwable e) {
		ErrorData data = new ErrorData();
		data.setMessage("An unknown error has occurred - " + e.getMessage());
		return data;
	}


}