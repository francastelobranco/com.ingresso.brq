package com.brqingresso.usuario.entrypoint.model.request;

import com.brqingresso.usuario.entrypoint.validation.Estado;
import com.brqingresso.usuario.entrypoint.validation.Pais;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
public class EnderecoModelRequest {

    @NotBlank
    @Size(max = 100)
    private String logradouro;

    @NotBlank
    @Size(max = 10)
    private String numero;

    @NotBlank
    @Size(max = 20)
    private String bairro;

    @NotBlank
    @Size(max = 20)
    private String cidade;

    @NotBlank
    @Estado
    @Size(min = 2, max = 2)
    private String estado;

    @NotBlank
    @Pais
    @Size(min = 2, max = 2)
    private String pais;

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;
}
