package com.brqingresso.usuario.entrypoint.handler;

import com.brqingresso.usuario.dataprovider.exception.ErroComunicacaoApiExternaException;
import com.brqingresso.usuario.dataprovider.exception.UsuarioNaoEncontradoException;
import com.brqingresso.usuario.usecase.exception.*;
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
        HttpStatus status = HttpStatus.CONFLICT;
        String type = "CPF_EM_USO";
        String tittle = "Cpf inválido";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(SenhaIncorretaException.class)
    public ResponseEntity<Object> handleSenhaIncorretaException(SenhaIncorretaException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "SENHA_INVÁLIDA";
        String tittle = "Senha inválida";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }


    @ExceptionHandler(ErroComunicacaoApiExternaException.class)
    public ResponseEntity<Object> handleComunicacaoApiExternaException(ErroComunicacaoApiExternaException ex, WebRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String type = "ERRO_INTERNO";
        String tittle = "Erro interno";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ViaCepExceptionBadRequest.class)
    public ResponseEntity<Object> handleViaCepExceptionExceptionBadRequest(ViaCepExceptionBadRequest ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "CEP_INVÁLIDO";
        String tittle = "Cep incorreto";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ViaCepExceptionNotFound.class)
    public ResponseEntity<Object> handleViaCepExceptionExceptionNotFound(ViaCepExceptionNotFound ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String type = "CEP_NAO_ENCONTRADO";
        String tittle = "Cep inválido";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }



    @ExceptionHandler(CodigoSegurancaIncorretoException.class)
    public ResponseEntity<Object> handleSenhaIncorretaException(CodigoSegurancaIncorretoException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String type = "CODIGO_INCORRETO";
        String tittle = "Código de segurança incorreto";
        String detail = ex.getMessage();
        ResponseException responseException = criaResponseException(status, type, tittle, detail).build();
        return handleExceptionInternal(ex, responseException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(TokenExpiradoException.class)
    public ResponseEntity<Object> handleSenhaIncorretaException(TokenExpiradoException ex, WebRequest request){
        HttpStatus status = HttpStatus.REQUEST_TIMEOUT;
        String type = "TOKEN_EXPIRADO";
        String tittle = "Token de segurança expirado";
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
