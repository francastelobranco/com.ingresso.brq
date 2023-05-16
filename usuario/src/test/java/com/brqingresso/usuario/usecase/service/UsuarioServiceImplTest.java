package com.brqingresso.usuario.usecase.service;

import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.gateway.UsuarioGateway;
import com.brqingresso.usuario.usecase.service.mock.UsuarioRequestTest;
import com.brqingresso.usuario.usecase.service.mock.UsuarioResponseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {



    @Mock
    UsuarioGateway usuarioGateway;
    @InjectMocks
    UsuarioServiceImpl service;
    UsuarioDomain usuario;




//    @Test
//    void cadastrarUsuario() {
//
//

//        var usuarioRequest = UsuarioRequestTest.mockUsuarioDomain();
//        var usuarioResponse = UsuarioResponseTest.mockUsuarioDomain();
//
//
//
//
//        Mockito.when(UUID.randomUUID().toString()).thenReturn("e1ea5412-3ae5-4910-a70b-d8af2c41b551");
//
//        Mockito.when(usuarioGateway.cadastrarUsuario(usuarioRequest)).thenReturn(usuarioResponse);
//
//
//        assertAll(
//                () -> assertEquals("e1ea5412-3ae5-4910-a70b-d8af2c41b551", usuario.getId()),
//                () -> assertEquals("12345678900", usuario.getCpf()),
//                () -> assertEquals("teste@teste.com.br", usuario.getEmail()),
//                () -> assertEquals("Amanda Silva", usuario.getNomeCompleto()),
//                () -> assertEquals("Amanda", usuario.getApelido()),
//                () -> assertEquals(LocalDate.of(2000,11,01), usuario.getDataNascimento()),
//                () -> assertEquals(91234567, usuario.getCelular()),
//                () -> assertEquals("F", usuario.getSexo()),
//                () -> assertEquals("Rua Vitor Alves", usuario.getEndereco().getLogradouro()),
//                () -> assertEquals("01", usuario.getEndereco().getNumero()),
//                () -> assertEquals("Campo Grande", usuario.getEndereco().getBairro()),
//                () -> assertEquals("Rio de Janeiro", usuario.getEndereco().getCidade()),
//                () -> assertEquals("Rj", usuario.getEndereco().getEstado()),
//                () -> assertEquals("Br", usuario.getEndereco().getPais()),
//                () -> assertEquals("23080180", usuario.getEndereco().getCep())
//        );

    }

//    @Test
//    void listarUsuarios() {
//
//        List<UsuarioDomain> usuarioResponse = UsuarioResponseTest.mockListaUsuarioDomain();
//
//        Mockito.when(service.listarUsuarios()).thenReturn(usuarioResponse);
//        List<UsuarioDomain> usuario = usuarioGateway.listarUsuarios();
//
//        assertAll(
//                () -> assertEquals("e1ea5412-3ae5-4910-a70b-d8af2c41b551", usuario.get(0).getId()),
//                () -> assertEquals("12345678900",usuario.get(0).getCpf()),
//                () -> assertEquals("teste@teste.com.br", usuario.get(0).getEmail()),
//                () -> assertEquals("Amanda Silva", usuario.get(0).getNomeCompleto()),
//                () -> assertEquals("Amanda", usuario.get(0).getApelido()),
//                () -> assertEquals(LocalDate.of(2000,11,01), usuario.get(0).getDataNascimento()),
//                () -> assertEquals(91234567, usuario.get(0).getCelular()),
//                () -> assertEquals("F", usuario.get(0).getSexo()),
//                () -> assertEquals("Rua Vitor Alves", usuario.get(0).getEndereco().getLogradouro()),
//                () -> assertEquals("01", usuario.get(0).getEndereco().getNumero()),
//                () -> assertEquals("Campo Grande", usuario.get(0).getEndereco().getBairro()),
//                () -> assertEquals("Rio de Janeiro", usuario.get(0).getEndereco().getCidade()),
//                () -> assertEquals("Rj", usuario.get(0).getEndereco().getEstado()),
//                () -> assertEquals("Br", usuario.get(0).getEndereco().getPais()),
//                () -> assertEquals("23080180", usuario.get(0).getEndereco().getCep())
//        );
//    }
//
//    @Test
//    void detalharUsuario() {
//        var id = "e1ea5412-3ae5-4910-a70b-d8af2c41b551";
//        var usuarioResponse = UsuarioResponseTest.mockUsuarioDomain();
//
//        Mockito.when(service.detalharUsuario(id)).thenReturn(usuarioResponse);
//        var usuario = usuarioGateway.detalharUsuario(id);
//
//        assertAll(
//                () -> assertEquals("e1ea5412-3ae5-4910-a70b-d8af2c41b551", usuario.getId()),
//                () -> assertEquals("12345678900", usuario.getCpf()),
//                () -> assertEquals("teste@teste.com.br", usuario.getEmail()),
//                () -> assertEquals("Amanda Silva", usuario.getNomeCompleto()),
//                () -> assertEquals("Amanda", usuario.getApelido()),
//                () -> assertEquals(LocalDate.of(2000,11,01), usuario.getDataNascimento()),
//                () -> assertEquals(91234567, usuario.getCelular()),
//                () -> assertEquals("F", usuario.getSexo()),
//                () -> assertEquals("Rua Vitor Alves", usuario.getEndereco().getLogradouro()),
//                () -> assertEquals("01", usuario.getEndereco().getNumero()),
//                () -> assertEquals("Campo Grande", usuario.getEndereco().getBairro()),
//                () -> assertEquals("Rio de Janeiro", usuario.getEndereco().getCidade()),
//                () -> assertEquals("Rj", usuario.getEndereco().getEstado()),
//                () -> assertEquals("Br", usuario.getEndereco().getPais()),
//                () -> assertEquals("23080180", usuario.getEndereco().getCep())
//        );
//    }

//    @Test
//    void deletarUsuario() {
//
//        var id = "e1ea5412-3ae5-4910-a70b-d8af2c41b551";
//        var usuarioResponse = UsuarioResponseTest.mockUsuarioDomain();
//
//        usuarioGateway.deletarUsuario(id);
//        var usuario = usuarioGateway.detalharUsuario(id);
//    }
