package com.brqingresso.usuario.usecase.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EnderecoDomain {

    String logradouro;
    String numero;
    String bairro;
    String cidade;
    String estado;
    String pais;
    String cep;
}
