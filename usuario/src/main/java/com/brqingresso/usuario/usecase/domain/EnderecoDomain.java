package com.brqingresso.usuario.usecase.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDomain {

    String logradouro;
    String numero;
    String bairro;
    String cidade;
    String estado;
    String pais;
    String cep;
}
