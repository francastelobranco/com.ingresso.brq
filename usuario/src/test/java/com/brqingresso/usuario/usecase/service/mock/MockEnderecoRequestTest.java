package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;

public class MockEnderecoRequestTest {

    public static EnderecoDomain mockEnderecoDomain(){
        return EnderecoDomain.builder()
                .numero("01")
                .complemento("casa")
                .cep("23080180")
                .build();
    }


}
