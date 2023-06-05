package com.brqingresso.usuario.dataprovider.implementation;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.exception.UsuarioNaoEncontradoException;
import com.brqingresso.usuario.dataprovider.http.ConsultaApi;
import com.brqingresso.usuario.dataprovider.mapper.request.UsuarioRequestMapperProvider;
import com.brqingresso.usuario.dataprovider.mapper.response.UsuarioResponseMapperProvider;
import com.brqingresso.usuario.dataprovider.repository.UsuarioRepository;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;
import com.brqingresso.usuario.usecase.exception.ErroComunicacaoApiExternaException;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    ConsultaApi consultaApi;

    @Override
    public UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain) {
        UsuarioEntity usuarioEntity = UsuarioRequestMapperProvider.convertToEntity(usuarioDomain);
        usuarioEntity = repository.save(usuarioEntity);
        usuarioDomain = UsuarioResponseMapperProvider.convertToDomain(usuarioEntity);

        return usuarioDomain;
    }

    @Override
    public List<UsuarioDomain> listarUsuarios() {
        List<UsuarioEntity> usuariosEntity = repository.findAll();
        List<UsuarioDomain> usuariosDomain = UsuarioResponseMapperProvider.convertToDomainList(usuariosEntity);
        return usuariosDomain;
    }

    @Override
    public UsuarioDomain detalharUsuario(String id) {
       UsuarioEntity usuarioEntity = repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(String.format("Usuário com ID %s não cadastrado", id)));
       UsuarioDomain usuarioDomain = UsuarioResponseMapperProvider.convertToDomain(usuarioEntity);
       return usuarioDomain;
    }

    @Override
    public UsuarioDomain atualizarUsuario(UsuarioDomain usuarioDomain) {
        UsuarioEntity usuarioEntity = UsuarioRequestMapperProvider.convertToEntityUpdate(usuarioDomain);
        usuarioEntity = repository.save(usuarioEntity);

        usuarioDomain = UsuarioResponseMapperProvider.convertToDomain(usuarioEntity);
        return usuarioDomain;
    }

    @Override
    public void deletarUsuario(String id) {
        UsuarioEntity usuarioEntity = repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(String.format("Não existe usuário com id: %s", id )));
        repository.delete(usuarioEntity);
    }

    @Override
    public boolean verificaCpfExiste(String cpf) {
        return  repository.existsByCpf(cpf);
    }

    @Override
    public EnderecoViaCep consultaCep(String cep) throws ErroComunicacaoApiExternaException {
        try {
            EnderecoViaCep endereco = consultaApi.consultaCep(cep);
            return endereco;
        } catch (IOException e) {
            throw new ErroComunicacaoApiExternaException("Erro na comunicação com a API externa: " + e.getMessage());
        }
    }
}
