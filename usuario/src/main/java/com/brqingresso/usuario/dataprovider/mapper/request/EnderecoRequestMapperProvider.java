package com.brqingresso.usuario.dataprovider.mapper.request;

import com.brqingresso.usuario.dataprovider.entity.EnderecoEntity;
import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.entrypoint.mapper.request.EnderecoEntryPointMapperRequest;
import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;

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
                .build();
    }
}
