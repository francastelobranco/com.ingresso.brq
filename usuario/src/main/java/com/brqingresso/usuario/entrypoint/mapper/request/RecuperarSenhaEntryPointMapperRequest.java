package com.brqingresso.usuario.entrypoint.mapper.request;

import com.brqingresso.usuario.entrypoint.model.request.RecuperarSenhaModelRequest;
import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;

public class RecuperarSenhaEntryPointMapperRequest {

    public static RecuperarSenhaDomain convertToDomain(RecuperarSenhaModelRequest senha){

        return RecuperarSenhaDomain.builder()
                .codigoSeguranca(senha.getCodigoSeguranca())
                .novaSenha(senha.getNovaSenha())
                .build();
    }
}
