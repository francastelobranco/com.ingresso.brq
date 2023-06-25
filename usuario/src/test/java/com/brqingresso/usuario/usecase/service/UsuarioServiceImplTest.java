package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.usecase.domain.SenhaDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.exception.DataIncorretaException;
import com.brqingresso.usuario.usecase.exception.SenhaIncorretaException;
import com.brqingresso.usuario.usecase.exception.ViaCepExceptionBadRequest;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import com.brqingresso.usuario.usecase.service.mock.MockEnderecoResponseTest;
import com.brqingresso.usuario.usecase.service.mock.MockUsuarioRequestTest;
import com.brqingresso.usuario.usecase.service.mock.MockUsuarioResponseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    UsuarioGateway usuarioGateway;

    @InjectMocks
    UsuarioServiceImpl service;

    static OffsetDateTime dataCadastro = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static OffsetDateTime dataAtualizacao = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
    static LocalDate dataNascimento = LocalDate.of(2000,11,01);

    @Test
    void testaCadastroDeUsuario() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        var enderecoViaCep = MockEnderecoResponseTest.mockEnderecoViaCep();

        when(usuarioGateway.cadastrarUsuario(any())).thenReturn(usuarioResponse);
        when(usuarioGateway.consultaCep(any())).thenReturn(enderecoViaCep);
        var usuarios = service.cadastrarUsuario(usuarioRequest);

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarios.getId()),
                () -> assertEquals("16064743751", usuarios.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuarios.getEmail()),
                () -> assertEquals("Amanda Silva", usuarios.getNomeCompleto()),
                () -> assertEquals("Amanda", usuarios.getApelido()),
                () -> assertEquals(dataNascimento, usuarios.getDataNascimento()),
                () -> assertEquals(975142031L, usuarios.getCelular()),
                () -> assertEquals("F", usuarios.getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuarios.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuarios.getEndereco().getNumero()),
                () -> assertEquals("casa", usuarios.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuarios.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuarios.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuarios.getEndereco().getEstado()),
                () -> assertEquals("Br", usuarios.getEndereco().getPais()),
                () -> assertEquals("23080180", usuarios.getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuarios.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuarios.getDataAtualizacao())
        );
    }

    @Test
    void deveLancarExceptionAoPassarUmaDataFutura() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        usuarioRequest.setDataNascimento(LocalDate.of(2070,11,01));
        assertThrows(DataIncorretaException.class, () -> service.cadastrarUsuario(usuarioRequest));
    }
    @Test
    void deveLancarExceptionAoPassarUmCepMaior() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        usuarioRequest.getEndereco().setCep("230801801");
        assertThrows(ViaCepExceptionBadRequest.class, () -> service.cadastrarUsuario(usuarioRequest));
    }

    @Test
    void testaListagemDeUsuarios() {
        List<UsuarioDomain> listaUsuarios = new MockUsuarioResponseTest().mockListUsuarioDomainResponse();
        when(usuarioGateway.listarUsuarios()).thenReturn(listaUsuarios);
        var usuarios = service.listarUsuarios();


        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarios.get(0).getId()),
                () -> assertEquals("16064743751", usuarios.get(0).getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuarios.get(0).getEmail()),
                () -> assertEquals("Amanda Silva", usuarios.get(0).getNomeCompleto()),
                () -> assertEquals("Amanda", usuarios.get(0).getApelido()),
                () -> assertEquals(dataNascimento, usuarios.get(0).getDataNascimento()),
                () -> assertEquals(975142031L, usuarios.get(0).getCelular()),
                () -> assertEquals("F", usuarios.get(0).getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuarios.get(0).getEndereco().getLogradouro()),
                () -> assertEquals("01", usuarios.get(0).getEndereco().getNumero()),
                () -> assertEquals("casa", usuarios.get(0).getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuarios.get(0).getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuarios.get(0).getEndereco().getCidade()),
                () -> assertEquals("Rj", usuarios.get(0).getEndereco().getEstado()),
                () -> assertEquals("Br", usuarios.get(0).getEndereco().getPais()),
                () -> assertEquals("23080180", usuarios.get(0).getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuarios.get(0).getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuarios.get(0).getDataAtualizacao())
        );
    }

    @Test
    void testaDetalhamentoDeUsuario() {
        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioResponse);
        var usuarios = service.detalharUsuario("11fd54a0-afcb-411c-b1c2-9dae0ca57a67");

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarios.getId()),
                () -> assertEquals("16064743751", usuarios.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuarios.getEmail()),
                () -> assertEquals("Amanda Silva", usuarios.getNomeCompleto()),
                () -> assertEquals("Amanda", usuarios.getApelido()),
                () -> assertEquals(dataNascimento, usuarios.getDataNascimento()),
                () -> assertEquals(975142031L, usuarios.getCelular()),
                () -> assertEquals("F", usuarios.getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuarios.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuarios.getEndereco().getNumero()),
                () -> assertEquals("casa", usuarios.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuarios.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuarios.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuarios.getEndereco().getEstado()),
                () -> assertEquals("Br", usuarios.getEndereco().getPais()),
                () -> assertEquals("23080180", usuarios.getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuarios.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuarios.getDataAtualizacao())
        );
    }

    @Test
    void testaAtualizacaoDeUsuario() {
        UsuarioDomain usuarioRequest = new MockUsuarioRequestTest().mockUsuarioDomainRequest();
        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        var enderecoViaCep = MockEnderecoResponseTest.mockEnderecoViaCep();

        when(usuarioGateway.consultaCep(any())).thenReturn(enderecoViaCep);
        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioResponse);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuarioResponse);
        var usuarios = service.atualizarUsuario("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarioRequest);

        assertAll(
                () -> assertEquals("11fd54a0-afcb-411c-b1c2-9dae0ca57a67", usuarios.getId()),
                () -> assertEquals("16064743751", usuarios.getCpf()),
                () -> assertEquals("amanda@teste.com.br", usuarios.getEmail()),
                () -> assertEquals("Amanda Silva", usuarios.getNomeCompleto()),
                () -> assertEquals("Amanda", usuarios.getApelido()),
                () -> assertEquals(dataNascimento, usuarios.getDataNascimento()),
                () -> assertEquals(975142031L, usuarios.getCelular()),
                () -> assertEquals("F", usuarios.getSexo()),
                () -> assertEquals("Rua Vitor Alves", usuarios.getEndereco().getLogradouro()),
                () -> assertEquals("01", usuarios.getEndereco().getNumero()),
                () -> assertEquals("casa", usuarios.getEndereco().getComplemento()),
                () -> assertEquals("Campo Grande", usuarios.getEndereco().getBairro()),
                () -> assertEquals("Rio de Janeiro", usuarios.getEndereco().getCidade()),
                () -> assertEquals("Rj", usuarios.getEndereco().getEstado()),
                () -> assertEquals("BR", usuarios.getEndereco().getPais()),
                () -> assertEquals("23080180", usuarios.getEndereco().getCep()),
                () -> assertEquals(dataCadastro, usuarios.getDataCadastro()),
                () -> assertEquals(dataAtualizacao, usuarios.getDataAtualizacao())
        );
    }

    @Test
    void testaDeletarDeUsuario() {
        String idUsuario = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        service.deletarUsuario(idUsuario);
        verify(usuarioGateway).deletarUsuario(idUsuario);
    }

    @Test
    void testaAlterarSenhaUsuario() {
        String idUsuario = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        SenhaDomain senha = new SenhaDomain();
        senha.setSenhaAtual("1234567");
        senha.setNovaSenha("123");

        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        usuarioResponse.setSenha("1234567");

        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioResponse);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuarioResponse);
        service.alterarSenha(idUsuario, senha);

        assertEquals("123", usuarioResponse.getSenha());
    }

    @Test
    void deveLancarExceptionInformarSenhaIncorreta() {
        String idUsuario = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        SenhaDomain senha = new SenhaDomain();
        senha.setSenhaAtual("1234567");
        senha.setNovaSenha("123");

        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        usuarioResponse.setSenha("123456");

        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioResponse);

        assertThrows(SenhaIncorretaException.class, () -> service.alterarSenha(idUsuario, senha));
    }

    @Test
    void testaGerarCodigoAlteracaoSenha() {
        UsuarioDomain usuarioResponse = new MockUsuarioResponseTest().mockUsuarioDomainResponse();
        usuarioResponse.setId("18c96aff-0a91-457b-b4f8-36e51f599612");

        when(service.detalharUsuario(any())).thenReturn(usuarioResponse);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuarioResponse);
        service.gerarCodigoAlteracaoSenha(usuarioResponse.getId());

        assertFalse(usuarioResponse.getCodigoSeguranca().isEmpty());
    }

//    @Test
//    void testaRecuperarSenhaUsuario() {
//
//        OffsetDateTime dataHora = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);
//
//
//        UsuarioDomain usuarioResponse = new UsuarioResponseTest().mockUsuarioDomainResponse();
//        usuarioResponse.setSenha("123");
//        usuarioResponse.setCodigoSeguranca("18c96aff-0a91-457b-b4f8-36e51f5996123");
//        usuarioResponse.setDataHoraCodigoSeguranca(dataHora);
//
//        RecuperarSenhaDomain recuperarSenha = new RecuperarSenhaTest().mockRecuperarSenha();
//
//
//        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioResponse);
//        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuarioResponse);
//        service.recuperarSenha(usuarioResponse.getId(), recuperarSenha);
//        assertEquals("123", usuarioResponse.getDataHoraCodigoSeguranca());
//        //assertEquals("123", usuarioResponse.getSenha());
//    }



}

