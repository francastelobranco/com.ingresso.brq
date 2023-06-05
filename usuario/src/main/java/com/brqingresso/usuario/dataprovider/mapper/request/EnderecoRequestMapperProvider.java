package com.brqingresso.usuario.dataprovider.mapper.request;

import com.brqingresso.usuario.dataprovider.entity.EnderecoApi;
import com.brqingresso.usuario.dataprovider.entity.EnderecoEntity;
import com.brqingresso.usuario.usecase.domain.EnderecoDomain;

public class EnderecoRequestMapperProvider {

    public static EnderecoEntity convertToEntity(EnderecoDomain enderecoDomain){

        return EnderecoEntity.builder()
                .logradouro(enderecoDomain.getLogradouro())
                .numero(enderecoDomain.getNumero())
                .bairro(enderecoDomain.getBairro())
                .cidade(enderecoDomain.getCidade())
                .estado(enderecoDomain.getEstado())
                .pais(enderecoDomain.getPais())
                .cep(enderecoDomain.getCep())
                .complemento(enderecoDomain.getComplemento())
                .build();
    }

    public static EnderecoDomain convertToApiDomain(EnderecoApi endereco){

        return EnderecoDomain.builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getLocalidade())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .estado(endereco.getUf())
                .build();
    }
}
