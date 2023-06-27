package com.brqingresso.usuario.mock;

import com.brqingresso.usuario.dataprovider.entity.EnderecoEntity;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;


public class EnderecoEntityMock {

    public static EnderecoEntity getMockEnderecoEntity(){
        return EnderecoEntity.builder()
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
}
