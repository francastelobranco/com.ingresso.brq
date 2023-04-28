package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;

import java.util.List;

public class EnderecoRequestTest {

    public static EnderecoDomain mockEnderecoDomain(){
        return EnderecoDomain.builder()
                .logradouro("Rua Vitor Alves")
                .numero("01")
                .bairro("Campo Grande")
                .cidade("Rio de Janeiro")
                .estado("Rj")
                .pais("Br")
                .cep("23080180")
                .build();
    }
}
