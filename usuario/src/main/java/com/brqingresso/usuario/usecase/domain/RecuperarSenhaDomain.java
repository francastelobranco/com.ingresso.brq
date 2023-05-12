package com.brqingresso.usuario.usecase.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecuperarSenhaDomain {

    private String codigoSeguranca;
    private String novaSenha;
}
