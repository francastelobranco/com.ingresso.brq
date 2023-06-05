package com.brqingresso.usuario.dataprovider.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoApi {

    String logradouro;
    String localidade;
    String uf;
    String bairro;
    String cep;
    String complemento;
}
