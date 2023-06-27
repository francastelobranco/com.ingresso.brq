package com.brqingresso.usuario.entrypoint.mapper.response;

import com.brqingresso.usuario.entrypoint.model.response.UsuarioModelResponse;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioEntryPointMapperResponse {

    public static UsuarioModelResponse convertToModel(UsuarioDomain usuarioDomain){

        return UsuarioModelResponse.builder()
                .id(usuarioDomain.getId())
                .cpf(usuarioDomain.getCpf())
                .email(usuarioDomain.getEmail())
                .nomeCompleto(usuarioDomain.getNomeCompleto())
                .apelido(usuarioDomain.getApelido())
                .dataCadastro(usuarioDomain.getDataCadastro())
                .dataNascimento(usuarioDomain.getDataNascimento())
                .dataAtualizacao(usuarioDomain.getDataAtualizacao())
                .celular(usuarioDomain.getCelular())
                .sexo(usuarioDomain.getSexo())
                .endereco(EnderecoEntryPointMapperResponse.convertToModel(usuarioDomain.getEndereco()))
                .build();
    }

    public static UsuarioModelResponse convert(UsuarioDomain usuarioDomain){

        return UsuarioModelResponse.builder()
                    .id(usuarioDomain.getId())
                    .cpf(usuarioDomain.getCpf())
                    .email(usuarioDomain.getEmail())
                    .nomeCompleto(usuarioDomain.getNomeCompleto())
                    .build();
    }

    public static List<UsuarioModelResponse> convertToModelList(List<UsuarioDomain> listaUsuariosDomain){

        return listaUsuariosDomain.stream()
                .map(usuarioDomain -> convert(usuarioDomain))
                .collect(Collectors.toList());
    }

}
