package com.brqingresso.usuario.entrypoint.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoValidator implements ConstraintValidator<Estado, String> {
    @Override
    public void initialize(Estado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valido = true;

        String[] estadosValidos = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

        boolean estadoEncontrado = false;

        for (String estadoValido : estadosValidos) {
            if (estadoValido.equalsIgnoreCase(value)) {
                estadoEncontrado = true;
            }
        }
        if (!estadoEncontrado){
            return valido = false;
        }
        return valido;
    }
}
