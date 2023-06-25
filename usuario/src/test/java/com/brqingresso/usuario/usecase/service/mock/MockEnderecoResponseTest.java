package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;


public class MockEnderecoResponseTest {

    public static EnderecoDomain mockEnderecoDomain(){
        return EnderecoDomain.builder()
                .logradouro("Rua Vitor Alves")
                .numero("01")
                .complemento("casa")
                .bairro("Campo Grande")
                .cidade("Rio de Janeiro")
                .estado("Rj")
                .pais("Br")
                .cep("23080180")
                .build();
    }

    public static EnderecoViaCep mockEnderecoViaCep(){
        return EnderecoViaCep.builder()
                .cep("23080180")
                .logradouro("Rua Vitor Alves")
                .complemento("casa")
                .bairro("Campo Grande")
                .localidade("Rio de Janeiro")
                .uf("Rj")
                .build();
    }

    public static EnderecoViaCep mockEnderecoViaCepException(){
        return EnderecoViaCep.builder()
                .cep("230801801")
                .logradouro("Rua Vitor Alves")
                .complemento("casa")
                .bairro("Campo Grande")
                .localidade("Rio de Janeiro")
                .uf("Rj")
                .build();
    }
}
