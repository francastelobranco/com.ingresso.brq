package com.brqingresso.usuario.entrypoint.controller;

import com.brqingresso.usuario.entrypoint.mapper.request.UsuarioEntryPointMapperRequest;
import com.brqingresso.usuario.entrypoint.mapper.response.UsuarioEntryPointMapperResponse;
import com.brqingresso.usuario.entrypoint.model.request.UsuarioModelRequest;
import com.brqingresso.usuario.entrypoint.model.response.UsuarioModelResponse;
import com.brqingresso.usuario.usecase.domain.UsuarioDomain;
import com.brqingresso.usuario.usecase.service.UsuarioUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/challengebrq/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping
    public ResponseEntity<UsuarioModelResponse> cadastrarUsuario(@RequestBody UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuarioDomain = UsuarioEntryPointMapperRequest.convertToDomain(usuarioModelRequest);
        usuarioDomain = usuarioUseCase.cadastrarUsuario(usuarioDomain);
        UsuarioModelResponse usuarioModel = UsuarioEntryPointMapperResponse.convertToModel(usuarioDomain);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModelResponse>> listarUsuarios(){
        List<UsuarioDomain> listaUsuarioDomain = usuarioUseCase.listarUsuarios();
        List<UsuarioModelResponse> usuariosModel = UsuarioEntryPointMapperResponse.convertToModelList(listaUsuarioDomain);

        return ResponseEntity.status(HttpStatus.OK).body(usuariosModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModelResponse> detalharUsuario(@PathVariable(value = "id") String id){
        UsuarioDomain usuarioDomain = usuarioUseCase.detalharUsuario(id);
        UsuarioModelResponse usuarioModel = UsuarioEntryPointMapperResponse.convertToModel(usuarioDomain);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable(value = "id") String id){
        usuarioUseCase.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{idUsuario}")
    public ResponseEntity<UsuarioModelResponse> atualizarUsuario(@PathVariable(value = "idUsuario") String idUsuario,
                                                                 @RequestBody Map<String, Object> camposUpdateModelRequest){

        UsuarioDomain usuarioRequest = UsuarioEntryPointMapperRequest.convertToDomainUpdate(camposUpdateModelRequest);
        UsuarioDomain usuarioAtualizado = usuarioUseCase.atualizarUsuario(idUsuario, usuarioRequest);
        UsuarioModelResponse usuarioAtualizadoModel = UsuarioEntryPointMapperResponse.convertToModel(usuarioAtualizado);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizadoModel);
    }

}
