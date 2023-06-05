package com.brqingresso.usuario.usecase.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDomain {

    @Setter
    String id;
    String cpf;
    String email;
    String nomeCompleto;
    String senha;
    String apelido;
    LocalDate dataNascimento;
    Long celular;
    String sexo;
    OffsetDateTime dataCadastro;
    OffsetDateTime dataAtualizacao;
    String codigoSeguranca;
    OffsetDateTime dataHoraCodigoSeguranca;
    EnderecoDomain endereco;
}
