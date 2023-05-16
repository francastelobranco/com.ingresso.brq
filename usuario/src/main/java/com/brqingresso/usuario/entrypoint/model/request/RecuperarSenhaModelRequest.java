package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class RecuperarSenhaModelRequest {

    private UUID codigoSeguranca;
    private String novaSenha;
}
