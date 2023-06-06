package com.brqingresso.usuario.usecase.exception;

public class ViaCepExceptionBadRequest extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ViaCepExceptionBadRequest(String message) {
        super(message);
    }
}