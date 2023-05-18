package com.brqingresso.usuario.usecase.exception;

public class DataIncorretaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIncorretaException(String message) {
        super(message);
    }
}
