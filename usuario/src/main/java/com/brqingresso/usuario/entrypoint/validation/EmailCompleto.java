package com.brqingresso.usuario.entrypoint.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
public @interface EmailCompleto {


    String message() default "O formato do e-mail informado não é válido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
