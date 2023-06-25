package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;

import java.util.UUID;

public class RecuperarSenhaTest {

    public static RecuperarSenhaDomain mockRecuperarSenha(){
        return RecuperarSenhaDomain.builder()
                .codigoSeguranca(UUID.fromString("18c96aff-0a91-457b-b4f8-36e51f5996123"))
                .novaSenha("1234")
                .build();
    }
}
