package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
public class EnderecoModelRequest {

    @NotBlank
    //@Size(min = 8, max = 8)
    private String cep;

    @NotBlank
    @Size(max = 10)
    private String numero;

    private String complemento;
}
