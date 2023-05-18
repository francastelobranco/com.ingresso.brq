package com.brqingresso.usuario.entrypoint.handler;

import com.brqingresso.usuario.dataprovider.exception.UsuarioNaoEncontradoException;
import com.brqingresso.usuario.usecase.exception.CpfEmUsoException;
import com.brqingresso.usuario.usecase.exception.DataIncorretaException;
import com.brqingresso.usuario.usecase.exception.SenhaIncorretaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Object> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String type = "ENTIDADE_NAO_ENCONTRADA";
        String tittle = "Usuário não encontrado";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(DataIncorretaException.class)
    public ResponseEntity<Object> handleDataIncorretaException(DataIncorretaException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "DATA_INCORRETA";
        String tittle = "Data incorreta";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(CpfEmUsoException.class)
    public ResponseEntity<Object> handleCpfEmUsoException(CpfEmUsoException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "CPF_EM_USO";
        String tittle = "Cpf inválido";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(SenhaIncorretaException.class)
    public ResponseEntity<Object> handleSenhaIncorretaException(SenhaIncorretaException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "SENHA_INCORRETA";
        String tittle = "Senha incorreta";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){
        if (body == null){
            body = ResponseException.builder()
                    .timestamp(OffsetDateTime.now())
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        } else if (body instanceof String) {
            body = ResponseException.builder()
                    .timestamp(OffsetDateTime.now())
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseException.ResponseExceptionBuilder criaResponseException(HttpStatus httpStatus, String type, String tittle, String detail) {

        return ResponseException.builder()
                .timestamp(OffsetDateTime.now())
                .status(httpStatus.value())
                .type(type)
                .detail(detail)
                .title(tittle);
    }
}
