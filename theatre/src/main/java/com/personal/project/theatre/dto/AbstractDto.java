package com.personal.project.theatre.dto;

import com.personal.project.model.ApiStatus;
import com.personal.project.model.data.FieldErrorData;
import com.personal.project.model.ApiException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AbstractDto {


    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> Set<ConstraintViolation<T>> validObject(T t) {
        return factory.getValidator().validate(t);
    }

    protected static <T> void validate(T obj) throws ApiException {
        checkValid(obj);
    }

    public static <T> void checkValid(T obj) throws ApiException {
        Set<ConstraintViolation<T>> violations = validObject(obj);
        if (violations.isEmpty()) {
            return;
        }
        List<FieldErrorData> errorList = new ArrayList<FieldErrorData>(violations.size());
        for (ConstraintViolation<T> violation : violations) {
            FieldErrorData error = new FieldErrorData();
            error.setCode("");
            error.setField(violation.getPropertyPath().toString());
            error.setMessage(violation.getMessage());
            errorList.add(error);
        }
        throw new ApiException(ApiStatus.BAD_DATA, "Input validation failed", errorList);
    }
}

