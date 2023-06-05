package com.brqingresso.usuario.usecase.mapper;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;

public class EnderecoViaCepMapperRequest {

    public static EnderecoDomain converteToDomain(EnderecoViaCep endereco){
        return EnderecoDomain.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getLocalidade())
                .estado(endereco.getUf())
                .build();

    }
}
