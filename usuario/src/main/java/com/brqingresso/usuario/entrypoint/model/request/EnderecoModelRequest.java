package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EnderecoModelRequest {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
}
