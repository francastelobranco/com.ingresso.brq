package com.brqingresso.usuario.usecase.exception;

public class CpfEmUsoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CpfEmUsoException(String message) {
        super(message);
    }
}
