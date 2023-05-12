package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SenhaModelRequest {

    private String senhaAtual;
    private String novaSenha;
}
