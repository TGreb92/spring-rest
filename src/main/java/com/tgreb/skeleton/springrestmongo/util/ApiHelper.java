package com.tgreb.skeleton.springrestmongo.util;

import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

@UtilityClass
public class ApiHelper {
    private final static Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(final Object object) {
        var violations = VALIDATOR.validate(object);
        if (!violations.isEmpty()) {
            var message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .findFirst();
            throw new IllegalArgumentException(message.get());
        }
    }


}
