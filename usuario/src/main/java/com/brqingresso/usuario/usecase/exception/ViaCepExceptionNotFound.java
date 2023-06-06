package com.brqingresso.usuario.usecase.exception;

public class ViaCepExceptionNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ViaCepExceptionNotFound(String message) {
        super(message);
    }
}