package com.brqingresso.usuario.usecase.exception;

public class ErroComunicacaoApiExternaException extends Exception {

    private static final long serialVersionUID = 1L;

    public ErroComunicacaoApiExternaException(String message) {
        super(message);
    }
}