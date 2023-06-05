package com.brqingresso.usuario.usecase.exception;

public class TokenExpiradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TokenExpiradoException(String message) {
        super(message);
    }
}