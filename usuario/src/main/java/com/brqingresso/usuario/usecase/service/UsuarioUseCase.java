package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.entrypoint.model.request.SenhaModelRequest;
import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;
import com.brqingresso.usuario.usecase.domain.SenhaDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;

import java.util.List;
import java.util.Map;

public interface UsuarioUseCase {

    UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain);
    List<UsuarioDomain> listarUsuarios();
    UsuarioDomain detalharUsuario(String id);
    UsuarioDomain atualizarUsuario(String idUsuario, UsuarioDomain usuarioRequest);
    void deletarUsuario(String id);
    void alterarSenha(String idUsuario, SenhaDomain senha);
    String gerarCodigoAlteracaoSenha(String idUsuario);
    void recuperarSenha(String idUsuario, RecuperarSenhaDomain recuperarSenha);
}
