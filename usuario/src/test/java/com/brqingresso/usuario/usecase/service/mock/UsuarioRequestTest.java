package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.time.LocalDate;
import java.util.List;

public class UsuarioRequestTest {

    public static UsuarioDomain mockUsuarioDomain(){
        return UsuarioDomain.builder()
                .cpf("12345678900")
                .email("teste@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .senha("123")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(91234567)
                .sexo("F")
                .endereco(EnderecoRequestTest.mockEnderecoDomain())
                .build();
    }

    public static List<UsuarioDomain> mockListaUsuarioDomain(){
        return List.of(UsuarioDomain.builder()
                .cpf("12345678900")
                .email("teste@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .senha("123")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(91234567)
                .sexo("F")
                .endereco(EnderecoRequestTest.mockEnderecoDomain())
                .build());
    }
}
