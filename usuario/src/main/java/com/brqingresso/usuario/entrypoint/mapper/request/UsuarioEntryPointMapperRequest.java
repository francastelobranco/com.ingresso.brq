package com.brqingresso.usuario.entrypoint.mapper.request;

import com.brqingresso.usuario.entrypoint.model.request.UsuarioModelRequest;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;
import java.util.Map;

public class UsuarioEntryPointMapperRequest {

    public static UsuarioDomain convertToDomain(UsuarioModelRequest usuario){

        return UsuarioDomain.builder()
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .nomeCompleto(usuario.getNomeCompleto())
                .senha(usuario.getSenha())
                .apelido(usuario.getApelido())
                .dataCadastro(OffsetDateTime.now().with(ChronoField.MILLI_OF_SECOND, 0))
                .dataNascimento(usuario.getDataNascimento())
                .celular(usuario.getCelular())
                .sexo(usuario.getSexo())
                .endereco(EnderecoEntryPointMapperRequest.convertToDomain(usuario.getEndereco()))
                .build();
    }

    public static UsuarioDomain convertToDomainUpdate(Map<String, Object> usuarioUpdateModelRequest) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        UsuarioDomain usuario = objectMapper.convertValue(usuarioUpdateModelRequest, UsuarioDomain.class);

        return usuario;
    }
}
