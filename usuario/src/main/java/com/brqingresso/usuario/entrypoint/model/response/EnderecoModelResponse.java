package com.brqingresso.usuario.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EnderecoModelResponse {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
}
