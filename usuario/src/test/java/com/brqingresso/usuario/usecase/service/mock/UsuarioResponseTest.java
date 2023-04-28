package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class UsuarioResponseTest {

    static OffsetDateTime dataHoraFuso = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);


    public static UsuarioDomain mockUsuarioDomain(){
        return UsuarioDomain.builder()
                .id("e1ea5412-3ae5-4910-a70b-d8af2c41b551")
                .cpf("12345678900")
                .email("teste@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .senha("123")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(91234567)
                .sexo("F")
                .dataCadastro(dataHoraFuso)
                .endereco(EnderecoResponseTest.mockEnderecoDomain())
                .build();
    }

    public static List<UsuarioDomain> mockListaUsuarioDomain(){
        return List.of(UsuarioDomain.builder()
                .id("e1ea5412-3ae5-4910-a70b-d8af2c41b551")
                .cpf("12345678900")
                .email("teste@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .senha("123")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(91234567)
                .sexo("F")
                .dataCadastro(dataHoraFuso)
                .endereco(EnderecoResponseTest.mockEnderecoDomain())
                .build());
    }
}
