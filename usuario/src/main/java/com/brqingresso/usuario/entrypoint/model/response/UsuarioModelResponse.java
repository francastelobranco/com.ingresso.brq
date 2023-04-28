package com.brqingresso.usuario.entrypoint.model.response;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioModelResponse {

    private String id;
    private String cpf;
    private String email;
    private String nomeCompleto;
    private String apelido;
    private LocalDate dataNascimento;
    private Integer celular;
    private String sexo;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataAtualizacao;
    private EnderecoModelResponse endereco;
}
