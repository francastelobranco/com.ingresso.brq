package com.brqingresso.usuario.usecase.gateway;

import com.brqingresso.usuario.usecase.domain.EnderecoDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;
import com.brqingresso.usuario.usecase.exception.ErroComunicacaoApiExternaException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UsuarioGateway {

    UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain);
    List<UsuarioDomain> listarUsuarios();
    UsuarioDomain detalharUsuario(String id);
    UsuarioDomain atualizarUsuario(UsuarioDomain usuarioDomain);
    void deletarUsuario(String id);
    boolean verificaCpfExiste(String cpf);
    EnderecoViaCep consultaCep(String cep) throws ErroComunicacaoApiExternaException;
}
