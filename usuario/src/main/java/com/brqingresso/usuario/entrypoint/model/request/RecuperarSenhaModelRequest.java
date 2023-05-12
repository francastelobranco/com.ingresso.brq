package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RecuperarSenhaModelRequest {

    private String codigoSeguranca;
    private String novaSenha;
}
