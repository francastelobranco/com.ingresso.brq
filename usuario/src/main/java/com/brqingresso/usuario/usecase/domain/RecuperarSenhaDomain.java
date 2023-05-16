package com.brqingresso.usuario.usecase.domain;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecuperarSenhaDomain {

    private UUID codigoSeguranca;
    private String novaSenha;
}
