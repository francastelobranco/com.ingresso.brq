package com.brqingresso.usuario.usecase.exception;

public class CodigoSegurancaIncorretoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CodigoSegurancaIncorretoException(String message) {
        super(message);
    }
}