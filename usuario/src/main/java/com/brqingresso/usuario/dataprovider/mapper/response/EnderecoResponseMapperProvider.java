package com.brqingresso.usuario.dataprovider.mapper.response;

import com.brqingresso.usuario.dataprovider.entity.EnderecoEntity;
import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EnderecoResponseMapperProvider {

    public static EnderecoDomain convertToModel(EnderecoEntity endereco){

        return EnderecoDomain.builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .pais(endereco.getPais())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .build();
    }
}
