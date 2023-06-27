package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;
import com.brqingresso.usuario.usecase.domain.SenhaDomain;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.exception.*;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import com.brqingresso.usuario.mock.EnderecoDomainMock;
import com.brqingresso.usuario.mock.UsuarioDomainMock;
import com.brqingresso.usuario.mock.RecuperarSenhaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

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
        UsuarioDomain usuarioRequest = new UsuarioDomainMock().getUsuarioMock();
        UsuarioDomain usuarioResponse = new UsuarioDomainMock().getUsuarioMock();
        var enderecoViaCep = EnderecoDomainMock.getMockEnderecoViaCep();

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
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setDataNascimento(LocalDate.of(2070,11,01));
        assertThrows(DataIncorretaException.class, () -> service.cadastrarUsuario(usuario));
    }
    @Test
    void deveLancarExceptionAoPassarUmCepMaior() {
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.getEndereco().setCep("230801801");
        assertThrows(ViaCepExceptionBadRequest.class, () -> service.cadastrarUsuario(usuario));
    }

    @Test
    void testaListagemDeUsuarios() {
        List<UsuarioDomain> listaUsuarios = new UsuarioDomainMock().getListUsuarioMock();
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
        UsuarioDomain usuarioDomain = new UsuarioDomainMock().getUsuarioMock();
        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuarioDomain);
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
        UsuarioDomain usuarioRequest = new UsuarioDomainMock().getUsuarioMock();
        UsuarioDomain usuarioResponse = new UsuarioDomainMock().getUsuarioMock();
        var enderecoViaCep = EnderecoDomainMock.getMockEnderecoViaCep();

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

        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setSenha("1234567");

        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuario);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuario);
        service.alterarSenha(idUsuario, senha);

        assertEquals("123", usuario.getSenha());
    }

    @Test
    void deveLancarExceptionInformarSenhaIncorreta() {
        String idUsuario = "11fd54a0-afcb-411c-b1c2-9dae0ca57a67";
        SenhaDomain senha = new SenhaDomain();
        senha.setSenhaAtual("1234567");
        senha.setNovaSenha("123");

        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setSenha("123456");

        when(usuarioGateway.detalharUsuario(any())).thenReturn(usuario);

        assertThrows(SenhaIncorretaException.class, () -> service.alterarSenha(idUsuario, senha));
    }

    @Test
    void testaGerarCodigoAlteracaoSenha() {
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setId("18c96aff-0a91-457b-b4f8-36e51f599612");

        when(service.detalharUsuario(any())).thenReturn(usuario);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuario);
        service.gerarCodigoAlteracaoSenha(usuario.getId());

        assertFalse(usuario.getCodigoSeguranca().isEmpty());
    }

    @Test
    void testaRecuperarSenhaUsuario() {

        OffsetDateTime dataHora = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);

        UUID codigo = UUID.randomUUID();

        String id = "4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3";
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setId("4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3");
        usuario.setSenha("123");
        usuario.setCodigoSeguranca(codigo.toString());
        usuario.setDataHoraCodigoSeguranca(dataHora);

        RecuperarSenhaDomain recuperarSenha = new RecuperarSenhaMock().getMockRecuperarSenha();
        recuperarSenha.setCodigoSeguranca(codigo);

        when(usuarioGateway.detalharUsuario(id)).thenReturn(usuario);
        when(usuarioGateway.atualizarUsuario(any())).thenReturn(usuario);
        var resposta = service.recuperarSenha(id, recuperarSenha);

        assertEquals("1234", resposta.getSenha());
    }

    @Test
    void deveLancarCodigoSegurancaIncorretoException() {
        OffsetDateTime dataHora = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);

        UUID codigoUm = UUID.randomUUID();
        UUID codigoDois = UUID.randomUUID();

        String id = "4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3";
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setId("4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3");
        usuario.setSenha("123");
        usuario.setCodigoSeguranca(codigoUm.toString());
        usuario.setDataHoraCodigoSeguranca(dataHora);

        RecuperarSenhaDomain recuperarSenha = new RecuperarSenhaMock().getMockRecuperarSenha();
        recuperarSenha.setCodigoSeguranca(codigoDois);

        when(usuarioGateway.detalharUsuario(id)).thenReturn(usuario);

        CodigoSegurancaIncorretoException excecao = assertThrows(CodigoSegurancaIncorretoException.class,
                () -> service.recuperarSenha(id, recuperarSenha));

        assertEquals("O codigo de segurança informado está incorreto", excecao.getMessage());
    }

    @Test
    void deveLancarSenhaIncorretaException() {
        OffsetDateTime dataHora = OffsetDateTime.of(2023, 12, 3, 2,2,2,2, ZoneOffset.UTC);

        UUID codigo = UUID.randomUUID();

        String id = "4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3";
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setId("4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3");
        usuario.setSenha("1234");
        usuario.setCodigoSeguranca(codigo.toString());
        usuario.setDataHoraCodigoSeguranca(dataHora);

        RecuperarSenhaDomain recuperarSenha = new RecuperarSenhaMock().getMockRecuperarSenha();
        recuperarSenha.setCodigoSeguranca(codigo);

        when(usuarioGateway.detalharUsuario(id)).thenReturn(usuario);

        SenhaIncorretaException excecao = assertThrows(SenhaIncorretaException.class,
                () -> service.recuperarSenha(id, recuperarSenha));

        assertEquals("A senha informada é a mesma que está cadastrada. Informe uma senha diferente", excecao.getMessage());
    }

    @Test
    void deveLancarTokenExpiradoException() {
        OffsetDateTime tempoExpirado = OffsetDateTime.now().minus(5, ChronoUnit.MINUTES);

        UUID codigo = UUID.randomUUID();

        String id = "4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3";
        UsuarioDomain usuario = new UsuarioDomainMock().getUsuarioMock();
        usuario.setId("4fa8c98f-a8fb-4fe8-8b0b-512c07fb46e3");
        usuario.setSenha("123");
        usuario.setCodigoSeguranca(codigo.toString());
        usuario.setDataHoraCodigoSeguranca(OffsetDateTime.now());
        usuario.setDataHoraCodigoSeguranca(tempoExpirado);

        RecuperarSenhaDomain recuperarSenha = new RecuperarSenhaMock().getMockRecuperarSenha();
        recuperarSenha.setCodigoSeguranca(codigo);

        when(usuarioGateway.detalharUsuario(id)).thenReturn(usuario);

        TokenExpiradoException excecao = assertThrows(TokenExpiradoException.class,
                () -> service.recuperarSenha(id, recuperarSenha));

        assertEquals("Token de segurança expirado", excecao.getMessage());
    }

}

