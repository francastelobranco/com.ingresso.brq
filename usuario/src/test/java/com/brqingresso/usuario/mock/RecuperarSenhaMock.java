package com.brqingresso.usuario.mock;

import com.brqingresso.usuario.usecase.domain.RecuperarSenhaDomain;

public class RecuperarSenhaMock {
    public static RecuperarSenhaDomain getMockRecuperarSenha(){
        return RecuperarSenhaDomain.builder()
                .novaSenha("1234")
                .build();
    }
}
