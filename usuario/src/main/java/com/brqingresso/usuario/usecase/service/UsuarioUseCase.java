package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.util.List;
import java.util.Map;

public interface UsuarioUseCase {

    UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain);
    List<UsuarioDomain> listarUsuarios();
    UsuarioDomain detalharUsuario(String id);
    UsuarioDomain atualizarUsuario(String idUsuario, UsuarioDomain usuarioRequest);
    void deletarUsuario(String id);
    //UsuarioDomain merge(Map<String, Object> camposOrigem, UsuarioDomain usuarioDetalhado);
//    UsuarioDomain mergeToDomain(String idUsuario, Map<String, Object> campos);
}
