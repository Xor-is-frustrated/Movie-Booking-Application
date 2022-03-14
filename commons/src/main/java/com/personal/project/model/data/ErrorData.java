package com.personal.project.model.data;

import com.personal.project.model.ApiStatus;

import java.util.ArrayList;
import java.util.Collection;

public class ErrorData {

    private ApiStatus code;
    private String message;
    private String description;
    private Collection<FieldErrorData> errors;

    public ErrorData() {
        setCode(ApiStatus.UNKNOWN_ERROR);
        setErrors(new ArrayList<FieldErrorData>(0));
    }


    public ApiStatus getCode() {
        return code;
    }

    public void setCode(ApiStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String stackStrace) {
        this.description = stackStrace;
    }

    public Collection<FieldErrorData> getErrors() {
        return errors;
    }

    public void setErrors(Collection<FieldErrorData> errors) {
        this.errors = errors;
    }

}