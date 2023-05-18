package com.brqingresso.usuario.entrypoint.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseException {

    private int status;
    private OffsetDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private List<Field> erros;

    @Getter
    @Builder
    public static class Field {
        private String field;
        private String detail;
    }
}
