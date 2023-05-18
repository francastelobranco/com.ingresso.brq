package com.brqingresso.usuario.usecase.exception;

public class SenhaIncorretaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SenhaIncorretaException(String message) {
        super(message);
    }
}
