package com.brqingresso.usuario.usecase.gateway;

import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {

    UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain);
    List<UsuarioDomain> listarUsuarios();
    UsuarioDomain detalharUsuario(String id);
    UsuarioDomain atualizarUsuario(UsuarioDomain usuarioDomain);
    void deletarUsuario(String id);
    boolean verificaCpfExiste(String cpf);
}
