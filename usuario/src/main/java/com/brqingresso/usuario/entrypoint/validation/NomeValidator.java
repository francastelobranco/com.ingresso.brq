package com.brqingresso.usuario.entrypoint.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeValidator implements ConstraintValidator<Nome, String> {
    @Override
    public void initialize(Nome constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valido = true;
        String regex = "(\\w)\\1{2}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);

        if (m.find()){
            valido = false;
        }
        return valido;
    }
}
