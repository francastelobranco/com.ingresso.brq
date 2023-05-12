package com.brqingresso.usuario.entrypoint.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Getter
public class UsuarioModelRequest {

    @NotBlank
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private String email;
    private String nomeCompleto;
    private String senha;
    private String apelido;
    private LocalDate dataNascimento;
    private Integer celular;
    private String sexo;

    @Valid
    private EnderecoModelRequest endereco;
}
