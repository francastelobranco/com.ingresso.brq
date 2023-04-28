package com.brqingresso.usuario.entrypoint.model.request;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class UsuarioModelRequest {

    private String cpf;
    private String email;
    private String nomeCompleto;
    private String senha;
    private String apelido;
    private LocalDate dataNascimento;
    private Integer celular;
    private String sexo;
    private EnderecoModelRequest endereco;
}
