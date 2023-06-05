package com.brqingresso.usuario.entrypoint.mapper.request;

import com.brqingresso.usuario.entrypoint.model.request.EnderecoModelRequest;
import com.brqingresso.usuario.usecase.domain.EnderecoDomain;

public class EnderecoEntryPointMapperRequest {

    public static EnderecoDomain convertToDomain(EnderecoModelRequest endereco){
        
        return EnderecoDomain.builder()
                .cep(endereco.getCep())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .build();
    }

    public static EnderecoDomain convertToDomainUpdate(EnderecoDomain endereco){

        return EnderecoDomain.builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .pais(endereco.getPais())
                .cep(endereco.getCep())
                .build();
    }
}
