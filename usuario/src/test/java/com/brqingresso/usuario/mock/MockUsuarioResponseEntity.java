package com.brqingresso.usuario.mock;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class MockUsuarioResponseEntity {
    static OffsetDateTime dataCadastro = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static OffsetDateTime dataAtualizacao = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);

    public UsuarioEntity getMockUsuarioEntity(){
        return UsuarioEntity.builder()
                .id("11fd54a0-afcb-411c-b1c2-9dae0ca57a67")
                .cpf("16064743751")
                .email("amanda@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(975142031L)
                .dataCadastro(dataCadastro)
                .dataAtualizacao(dataAtualizacao)
                .sexo(2)
                .senha("1234")
                .endereco(EnderecoEntityMock.getMockEnderecoEntity())
                .build();
    }
    public List<UsuarioEntity> getMockListUsuarioEntity(){
        return List.of(UsuarioEntity.builder()
                .id("11fd54a0-afcb-411c-b1c2-9dae0ca57a67")
                .cpf("16064743751")
                .email("amanda@teste.com.br")
                .nomeCompleto("Amanda Silva")
                .apelido("Amanda")
                .dataNascimento(LocalDate.of(2000,11,01))
                .celular(975142031L)
                .dataCadastro(dataCadastro)
                .dataAtualizacao(dataAtualizacao)
                .sexo(2)
                .endereco(EnderecoEntityMock.getMockEnderecoEntity())
                .build());
    }

}
