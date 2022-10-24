package com.hakim.entities;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Hakim
 */
public class ValidationUtil {

    private final Validator validator;
    private static final ValidationUtil INSTANCE=new ValidationUtil();

    public ValidationUtil() {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        validator = validationFactory.getValidator();
    }

    public static ValidationUtil getINSTANCE() {
        return INSTANCE;
    }

    public <T> Map<String, String> validate(T object) {
        var violations = validator.validate(object);

        return violations
                .stream()
                .collect(
                        Collectors.toMap(
                                violation -> violation.getPropertyPath().toString(),
                                ConstraintViolation::getMessage,
                                (msg1, msg2) -> msg1 + "<br/>" + msg2
                        )
                );
    }

}
