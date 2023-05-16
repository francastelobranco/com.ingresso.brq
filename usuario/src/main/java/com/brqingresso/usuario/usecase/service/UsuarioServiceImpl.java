package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;
import com.brqingresso.usuario.usecase.domain.SenhaDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class UsuarioServiceImpl implements UsuarioUseCase{

    @Autowired
    UsuarioGateway usuarioGateway;

    @Override
    public UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain) {
        validaCpfEmUso(usuarioDomain.getCpf());
        usuarioDomain.setId(UUID.randomUUID().toString());

        if(usuarioDomain.getDataNascimento().isAfter(LocalDate.now()))
        {
            throw new RuntimeException("A data informada é inválida.");
        }

        return usuarioGateway.cadastrarUsuario(usuarioDomain);
    }

    @Override
    public List<UsuarioDomain> listarUsuarios() {
        return usuarioGateway.listarUsuarios();
    }

    @Override
    public UsuarioDomain detalharUsuario(String id) {
        //todo: validar
        return usuarioGateway.detalharUsuario(id);
    }

    @Override
    public UsuarioDomain atualizarUsuario(String id, UsuarioDomain usuarioRequest) {
        UsuarioDomain usuarioExistente = detalharUsuario(id);


        if(StringUtils.isNotBlank(usuarioRequest.getNomeCompleto())){
            usuarioExistente.setNomeCompleto(usuarioRequest.getNomeCompleto());
        }

        if(StringUtils.isNotBlank(usuarioRequest.getApelido())){
            usuarioExistente.setApelido(usuarioRequest.getApelido());
        }

        if(Objects.nonNull(usuarioRequest.getDataNascimento())){
            if(usuarioRequest.getDataNascimento().isAfter(LocalDate.now()))
            {
                throw new RuntimeException("A data informada é inválida.");
            }
            usuarioExistente.setDataNascimento(usuarioRequest.getDataNascimento());
        }

        if(Objects.nonNull(usuarioRequest.getCelular())){
            usuarioExistente.setCelular(usuarioRequest.getCelular());
        }

        if(StringUtils.isNotBlank(usuarioRequest.getSexo())){
            usuarioExistente.setSexo(usuarioRequest.getSexo());
        }

        if(Objects.nonNull(usuarioRequest.getEndereco())){

            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getLogradouro())){
                usuarioExistente.getEndereco().setLogradouro(usuarioRequest.getEndereco().getLogradouro());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getNumero())){
                usuarioExistente.getEndereco().setNumero(usuarioRequest.getEndereco().getNumero());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getBairro())){
                usuarioExistente.getEndereco().setBairro(usuarioRequest.getEndereco().getBairro());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getCidade())){
                usuarioExistente.getEndereco().setCidade(usuarioRequest.getEndereco().getCidade());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getEstado())){
                usuarioExistente.getEndereco().setEstado(usuarioRequest.getEndereco().getEstado());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getPais())){
                usuarioExistente.getEndereco().setPais(usuarioRequest.getEndereco().getPais());
            }
            if (StringUtils.isNotBlank(usuarioRequest.getEndereco().getCep())){
                usuarioExistente.getEndereco().setCep(usuarioRequest.getEndereco().getCep());
            }

            usuarioExistente.setEndereco(usuarioRequest.getEndereco());
        }



        return usuarioGateway.atualizarUsuario(usuarioExistente);
    }

    @Override
    public void deletarUsuario(String id) {
        usuarioGateway.deletarUsuario(id);
    }

    @Override
    public void alterarSenha(String idUsuario, SenhaDomain senha) {
        var usuario = detalharUsuario(idUsuario);
        if (!usuario.getSenha().equals(senha.getSenhaAtual())){
            throw new RuntimeException("A senha atual está incorreta");
        }
        usuario.setSenha(senha.getNovaSenha());
        usuarioGateway.atualizarUsuario(usuario);
    }

    @Override
    public UUID gerarCodigoAlteracaoSenha(String idUsuario) {
        detalharUsuario(idUsuario);
        UUID codigo = UUID.randomUUID();
        return codigo;
    }

    @Override
    public void recuperarSenha(String idUsuario, RecuperarSenhaDomain recuperarSenha) {
        var usuario = detalharUsuario(idUsuario);

        if (!recuperarSenha.getCodigoSeguranca().equals(UUID.class)){
            System.out.println("é uuid");
        }
        try {
            recuperarSenha.getCodigoSeguranca();
            usuario.setSenha(recuperarSenha.getNovaSenha());

            usuarioGateway.atualizarUsuario(usuario);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }
    }

    private void validaCpfEmUso(String cpf) {
        boolean validaCpf = usuarioGateway.verificaCpfExiste(cpf);

        if (validaCpf) {
            throw new RuntimeException(String.format("O CPF %s já está cadastrado", cpf));
        }
    }

}
