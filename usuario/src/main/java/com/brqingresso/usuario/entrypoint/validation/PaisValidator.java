package com.brqingresso.usuario.entrypoint.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaisValidator implements ConstraintValidator<Pais, String> {
    @Override
    public void initialize(Pais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String pais, ConstraintValidatorContext context) {
        boolean valido = true;
        if (!pais.equalsIgnoreCase("br")){
            valido = false;
        }
        return valido;
    }
}
