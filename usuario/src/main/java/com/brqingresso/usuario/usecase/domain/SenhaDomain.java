package com.brqingresso.usuario.usecase.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SenhaDomain {


    private String senhaAtual;
    private String novaSenha;
}
