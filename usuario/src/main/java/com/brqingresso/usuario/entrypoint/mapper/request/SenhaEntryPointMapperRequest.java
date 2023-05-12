package com.brqingresso.usuario.entrypoint.mapper.request;

import com.brqingresso.usuario.entrypoint.model.request.SenhaModelRequest;
import com.brqingresso.usuario.usecase.domain.SenhaDomain;

public class SenhaEntryPointMapperRequest {

    public static SenhaDomain convertToDomain(SenhaModelRequest senha){

        return SenhaDomain.builder()
                .senhaAtual(senha.getSenhaAtual())
                .novaSenha(senha.getNovaSenha())
                .build();
    }
}
