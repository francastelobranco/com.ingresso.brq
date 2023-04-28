package com.brqingresso.usuario.dataprovider.implementation;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.mapper.request.UsuarioRequestMapperProvider;
import com.brqingresso.usuario.dataprovider.mapper.response.UsuarioResponseMapperProvider;
import com.brqingresso.usuario.dataprovider.repository.UsuarioRepository;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    UsuarioRepository repository;

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
        Optional<UsuarioEntity> usuarioEntity = repository.findById(id);
        UsuarioDomain usuarioDomain = UsuarioResponseMapperProvider.convertToDomain(usuarioEntity.get());
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
        UsuarioEntity usuarioEntity = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Não existe usuário com id: s%", id )));
        repository.delete(usuarioEntity);
    }
}
