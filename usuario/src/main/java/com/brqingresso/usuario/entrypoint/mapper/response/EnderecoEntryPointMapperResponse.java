package com.brqingresso.usuario.entrypoint.mapper.response;

import com.brqingresso.usuario.entrypoint.model.response.EnderecoModelResponse;
import com.brqingresso.usuario.usecase.domain.EnderecoDomain;

public class EnderecoEntryPointMapperResponse {

    public static EnderecoModelResponse convertToModel(EnderecoDomain enderecoDomain){

        return EnderecoModelResponse.builder()
                .logradouro(enderecoDomain.getLogradouro())
                .complemento(enderecoDomain.getComplemento())
                .numero(enderecoDomain.getNumero())
                .bairro(enderecoDomain.getBairro())
                .cidade(enderecoDomain.getCidade())
                .estado(enderecoDomain.getEstado())
                .pais(enderecoDomain.getPais())
                .cep(enderecoDomain.getCep())
                .build();
    }
}
