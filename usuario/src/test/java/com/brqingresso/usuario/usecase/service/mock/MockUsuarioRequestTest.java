package com.brqingresso.usuario.usecase.service.mock;

import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class MockUsuarioRequestTest {

    static OffsetDateTime dataCadastro = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static OffsetDateTime dataAtualizacao = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);

    public UsuarioDomain mockUsuarioDomainRequest(){
        return UsuarioDomain.builder()
                .cpf("16064743751")
                .email("amanda@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(975142031L)
                .dataCadastro(dataCadastro)
                .sexo("F")
                .senha("1234")
                .codigoSeguranca("18c96aff-0a91-457b-b4f8-36e51f599612")
                //.dataHoraCodigoSeguranca()
                .endereco(MockEnderecoRequestTest.mockEnderecoDomain())
                .build();
    }

//    public List<UsuarioDomain> mockListUsuarioDomainRequest(){
//        return List.of(UsuarioDomain.builder()
//                .cpf("16064743751")
//                .email("amanda@teste.com.br")
//                .nomeCompleto("Amanda Silva")
//                .apelido("Amanda")
//                .dataNascimento(LocalDate.of(2000,11,01))
//                .celular(975142031L)
//                .dataCadastro(dataCadastro)
//                .sexo("F")
//                .endereco(MockEnderecoRequestTest.mockEnderecoDomain())
//                .build());
//    }
}
