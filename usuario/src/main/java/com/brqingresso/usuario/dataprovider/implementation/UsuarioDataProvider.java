package com.brqingresso.usuario.dataprovider.implementation;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.exception.UsuarioNaoEncontradoException;
import com.brqingresso.usuario.dataprovider.http.ConsultaApi;
import com.brqingresso.usuario.dataprovider.mapper.request.UsuarioRequestMapperProvider;
import com.brqingresso.usuario.dataprovider.mapper.response.UsuarioResponseMapperProvider;
import com.brqingresso.usuario.dataprovider.repository.UsuarioRepository;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;
import com.brqingresso.usuario.usecase.exception.ViaCepExceptionNotFound;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
    @Cacheable("viacep")
    public EnderecoViaCep consultaCep(String cep) {
        EnderecoViaCep endereco = consultaApi.consultaCep(cep);

        if (Objects.isNull(endereco.getCep())){
            throw new ViaCepExceptionNotFound("O CEP informado não foi encontrado");
        }

        //simula latencia
        try {
            long tempo = 5000L;
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        return endereco;
    }

    @CacheEvict(value = "viacep", allEntries = true)
    @Scheduled(fixedRate = 30000)
    public void evictAllCacheValues() {}
}


