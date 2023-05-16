package com.brqingresso.usuario.entrypoint.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CelularValidator implements ConstraintValidator<Celular, Long> {

    @Override
    public void initialize(Celular constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean valido = true;
        var validar = String.valueOf(value);
        var digitoInicialTelefone = '9';
        int contador = 0;

        for (char letra : validar.toCharArray()) {
            if (contador == 2) {
                if (letra != digitoInicialTelefone){
                    valido = false;
                }
            }
            contador++;
        }
        return valido;
    }
}
