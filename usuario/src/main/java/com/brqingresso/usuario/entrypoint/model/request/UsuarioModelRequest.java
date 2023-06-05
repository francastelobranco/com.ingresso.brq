package com.brqingresso.usuario.entrypoint.model.request;

import com.brqingresso.usuario.entrypoint.validation.Celular;
import com.brqingresso.usuario.entrypoint.validation.EmailCompleto;
import com.brqingresso.usuario.entrypoint.validation.Nome;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Getter
public class UsuarioModelRequest {

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @EmailCompleto
    @Size(min = 5, max = 50)
    private String email;

    @NotBlank
    @Nome
    @Size(min = 2, max = 100)
    private String nomeCompleto;

    @NotBlank
    @Size(min = 2, max = 100)
    private String senha;

    @Size(max = 20)
    private String apelido;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull
    @Celular
    private Long celular;

    @NotBlank
   // @Size(max = 2)
    private String sexo;

    @Valid
    private EnderecoModelRequest endereco;
}
