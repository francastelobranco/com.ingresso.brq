package com.brqingresso.usuario.dataprovider.mapper.request;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.enums.SexoEnum;
import com.brqingresso.usuario.entrypoint.mapper.request.EnderecoEntryPointMapperRequest;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;

public class UsuarioRequestMapperProvider {

    public static UsuarioEntity convertToEntity(UsuarioDomain usuarioDomain){

        return UsuarioEntity.builder()
                .id(usuarioDomain.getId())
                .cpf(usuarioDomain.getCpf())
                .email(usuarioDomain.getEmail())
                .nomeCompleto(usuarioDomain.getNomeCompleto())
                .senha(usuarioDomain.getSenha())
                .apelido(usuarioDomain.getApelido())
                .dataCadastro(usuarioDomain.getDataCadastro())
                .dataNascimento(usuarioDomain.getDataNascimento())
                .celular(usuarioDomain.getCelular())
                .sexo(SexoEnum.getCodigoSexo(usuarioDomain.getSexo()))
                .endereco(EnderecoRequestMapperProvider.convertToEntity(usuarioDomain.getEndereco()))
                .build();
    }

    public static UsuarioEntity convertToEntityUpdate(UsuarioDomain usuario){

        return UsuarioEntity.builder()
                .id(usuario.getId())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .dataAtualizacao(OffsetDateTime.now().with(ChronoField.MILLI_OF_SECOND, 0))
                .nomeCompleto(usuario.getNomeCompleto())
                .apelido(usuario.getApelido())
                .dataCadastro(OffsetDateTime.now().with(ChronoField.MILLI_OF_SECOND, 0))
                .dataNascimento(usuario.getDataNascimento())
                .celular(usuario.getCelular())
                .sexo(SexoEnum.getCodigoSexo(usuario.getSexo()))
                .codigoSeguranca(usuario.getCodigoSeguranca())
                .dataHoraCodigoSeguranca(usuario.getDataHoraCodigoSeguranca())
                .endereco(EnderecoRequestMapperProvider.convertToEntity(usuario.getEndereco()))
                .build();
    }

}
