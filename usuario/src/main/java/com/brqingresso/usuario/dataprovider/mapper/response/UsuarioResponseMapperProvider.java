package com.brqingresso.usuario.dataprovider.mapper.response;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.enums.SexoEnum;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponseMapperProvider {

    public static UsuarioDomain convertToDomain(UsuarioEntity usuarioEntity){

        return UsuarioDomain.builder()
                .id(usuarioEntity.getId())
                .cpf(usuarioEntity.getCpf())
                .email(usuarioEntity.getEmail())
                .nomeCompleto(usuarioEntity.getNomeCompleto())
                .senha(usuarioEntity.getSenha())
                .apelido(usuarioEntity.getApelido())
                .dataCadastro(usuarioEntity.getDataCadastro())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .dataAtualizacao(usuarioEntity.getDataAtualizacao())
                .celular(usuarioEntity.getCelular())
                .sexo(SexoEnum.getSigla(usuarioEntity.getSexo()))
                .codigoSeguranca(usuarioEntity.getCodigoSeguranca())
                .dataHoraCodigoSeguranca(usuarioEntity.getDataHoraCodigoSeguranca())
                .endereco(EnderecoResponseMapperProvider.convertToModel(usuarioEntity.getEndereco()))
                .build();
    }

    public static UsuarioDomain convert(UsuarioEntity usuarioEntity){
        return UsuarioDomain.builder()
                .id(usuarioEntity.getId())
                .cpf(usuarioEntity.getCpf())
                .email(usuarioEntity.getEmail())
                .nomeCompleto(usuarioEntity.getNomeCompleto())
                .build();
    }

    public static List<UsuarioDomain> convertToDomainList(List<UsuarioEntity> listaUsuariosEntity) {
        return listaUsuariosEntity.stream()
                .map(usuarioEntity -> convert(usuarioEntity))
                .collect(Collectors.toList());
    }


}
