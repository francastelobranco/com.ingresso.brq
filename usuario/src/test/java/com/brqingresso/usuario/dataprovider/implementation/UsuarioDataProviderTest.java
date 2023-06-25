package com.brqingresso.usuario.dataprovider.implementation;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import com.brqingresso.usuario.dataprovider.exception.UsuarioNaoEncontradoException;
import com.brqingresso.usuario.dataprovider.http.ConsultaApi;
import com.brqingresso.usuario.dataprovider.implementation.mock.MockUsuarioResponseEntity;
import com.brqingresso.usuario.dataprovider.repository.UsuarioRepository;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.dto.EnderecoViaCep;
import com.brqingresso.usuario.usecase.exception.ViaCepExceptionBadRequest;
import com.brqingresso.usuario.usecase.exception.ViaCepExceptionNotFound;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import com.brqingresso.usuario.usecase.service.UsuarioServiceImpl;
import com.brqingresso.usuario.usecase.service.mock.MockEnderecoResponseTest;
import com.brqingresso.usuario.usecase.service.mock.MockUsuarioRequestTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioDataProviderTest {

    @Mock
    UsuarioRepository repository;

    @Mock
    ConsultaApi consultaApi;

    @InjectMocks
    UsuarioDataProvider usuarioGateway;

    static OffsetDateTime dataCadastro = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static OffsetDateTime dataAtualizacao = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static LocalDate dataNascimento = LocalDate.of(2000,11,01);

    @Test
    void cadastrarUsuario() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        UsuarioEntity usuarioEntity = new MockUsuarioResponseEntity().mockUsuarioEntity();

        when(repository.save(any())).thenReturn(usuarioEntity);
        var usuario = usuarioGateway.cadastrarUsuario(usuarioRequest);

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuario.getId()),
                () -> assertEquals("16064743751", usuario.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuario.getEmail()),
                () -> assertEquals("Amanda Silva", usuario.getNomeCompleto()),
                () -> assertEquals("Amanda", usuario.getApelido()),
                () -> assertEquals(dataNascimento, usuario.getDataNascimento()),
                () -> assertEquals(975142031L, usuario.getCelular()),
                () -> assertEquals("F", usuario.getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuario.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuario.getEndereco().getNumero()),
                () -> assertEquals("casa", usuario.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuario.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuario.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuario.getEndereco().getEstado()),
                () -> assertEquals("Br", usuario.getEndereco().getPais()),
                () -> assertEquals("23080180", usuario.getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuario.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuario.getDataAtualizacao())
        );

    }

    @Test
    void listarUsuarios() {
        List<UsuarioEntity> usuarioEntity = new MockUsuarioResponseEntity().mockListUsuarioEntity();

        when(repository.findAll()).thenReturn(usuarioEntity);
        var usuarios = usuarioGateway.listarUsuarios();

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarios.get(0).getId()),
                () -> assertEquals("16064743751", usuarios.get(0).getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuarios.get(0).getEmail()),
                () -> assertEquals("Amanda Silva", usuarios.get(0).getNomeCompleto())
        );
    }

    @Test
    void detalharUsuario() {
        String id = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        UsuarioEntity usuarioEntity = new MockUsuarioResponseEntity().mockUsuarioEntity();


        when(repository.findById(any())).thenReturn(Optional.ofNullable(usuarioEntity));
        var usuario = usuarioGateway.detalharUsuario(id);

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuario.getId()),
                () -> assertEquals("16064743751", usuario.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuario.getEmail()),
                () -> assertEquals("Amanda Silva", usuario.getNomeCompleto()),
                () -> assertEquals("Amanda", usuario.getApelido()),
                () -> assertEquals(dataNascimento, usuario.getDataNascimento()),
                () -> assertEquals(975142031L, usuario.getCelular()),
                () -> assertEquals("F", usuario.getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuario.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuario.getEndereco().getNumero()),
                () -> assertEquals("casa", usuario.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuario.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuario.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuario.getEndereco().getEstado()),
                () -> assertEquals("Br", usuario.getEndereco().getPais()),
                () -> assertEquals("23080180", usuario.getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuario.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuario.getDataAtualizacao())
        );
    }

    @Test
    void deveLancarUsuarioNaoEncontradoException() {
        String id = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        assertThrows(UsuarioNaoEncontradoException.class, () -> usuarioGateway.detalharUsuario(id));
    }

    @Test
    void atualizarUsuario() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        UsuarioEntity usuarioEntity = new MockUsuarioResponseEntity().mockUsuarioEntity();


        when(repository.save(any())).thenReturn(usuarioEntity);
        var usuario = usuarioGateway.atualizarUsuario(usuarioRequest);

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuario.getId()),
                () -> assertEquals("16064743751", usuario.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuario.getEmail()),
                () -> assertEquals("Amanda Silva", usuario.getNomeCompleto()),
                () -> assertEquals("1234", usuario.getSenha()),
                () -> assertEquals("Amanda", usuario.getApelido()),
                () -> assertEquals(dataCadastro, usuario.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuario.getDataAtualizacao()),
                () -> assertEquals(dataNascimento, usuario.getDataNascimento()),
                () -> assertEquals(975142031L, usuario.getCelular()),
                () -> assertEquals("F", usuario.getSexo()),
                //() -> assertEquals("18c96aff-0a91-457b-b4f8-36e51f599612", usuario.getCodigoSeguranca()),
                //() -> assertEquals("18c96aff-0a91-457b-b4f8-36e51f599612", usuario.getDataHoraCodigoSeguranca()),
                () -> assertEquals("Rua Vitor Alves", usuario.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuario.getEndereco().getNumero()),
                () -> assertEquals("casa", usuario.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuario.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuario.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuario.getEndereco().getEstado()),
                () -> assertEquals("Br", usuario.getEndereco().getPais()),
                () -> assertEquals("23080180", usuario.getEndereco().getCep())
        );
    }

    @Test
    void deletarUsuario() {
        UsuarioEntity usuarioEntity = new MockUsuarioResponseEntity().mockUsuarioEntity();
        String idUsuario = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";

        when(repository.findById(idUsuario)).thenReturn(Optional.of(usuarioEntity));
        usuarioGateway.deletarUsuario(idUsuario);
        verify(repository).delete(usuarioEntity);
    }


    @Test
    void verificaCpfExiste() {
        UsuarioEntity usuarioEntity = new MockUsuarioResponseEntity().mockUsuarioEntity();
        when(repository.existsByCpf(usuarioEntity.getCpf())).thenReturn(true);
        boolean cpfCadastrado = usuarioGateway.verificaCpfExiste(usuarioEntity.getCpf());
        assertTrue(cpfCadastrado);
    }

    @Test
    void consultaCep() {
        String cepNaoExistente = "12345678";
        EnderecoViaCep enderecoViaCep = new MockEnderecoResponseTest().mockEnderecoViaCep();
        enderecoViaCep.setCep("12345678");
        when(consultaApi.consultaCep(cepNaoExistente)).thenReturn(enderecoViaCep);
        EnderecoViaCep cepIncorreto = usuarioGateway.consultaCep(cepNaoExistente);
        assertEquals(cepNaoExistente, cepIncorreto.getCep());

    }

    @Test
    void deveLancarViaCepExceptionNotFound() {
        String cep = "12345678";
        EnderecoViaCep enderecoViaCep = new MockEnderecoResponseTest().mockEnderecoViaCep();
        enderecoViaCep.setCep(null);
        when(consultaApi.consultaCep(cep)).thenReturn(enderecoViaCep);

        ViaCepExceptionNotFound excecao = assertThrows(ViaCepExceptionNotFound.class,
                () -> usuarioGateway.consultaCep(cep));

        assertEquals("O CEP informado não foi encontrado", excecao.getMessage());
    }
}