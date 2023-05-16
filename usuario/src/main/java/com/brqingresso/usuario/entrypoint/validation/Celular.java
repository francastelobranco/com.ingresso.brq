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
@Constraint(validatedBy = {CelularValidator.class})
public @interface Celular {

    String message() default "O formato do número de celular informado não é válido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
