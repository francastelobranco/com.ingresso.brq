package com.brqingresso.usuario.dataprovider.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoEnum {

    MASCULINO("MASCULINO", "M", 1),
    FEMININO("FEMININO", "F", 2),
    NAO_BINARIO("NAO_BINARIO", "B", 3),
    NAO_INFORMAR("NAO_INFORMAR", "N", 4);

    private final String nome;
    private final String sigla;
    private final Integer codigo;

    public static Integer getCodigoSexo(String sigla) {
        for (SexoEnum sexo : SexoEnum.values()) {
            if (sexo.getSigla().equalsIgnoreCase(sigla)) {
                return sexo.getCodigo();
            }
        }
        throw new RuntimeException(String.format("Não foi possível encontrar a sigla: %s", sigla));
    }
    public static String getSigla(Integer codigo) {
        for (SexoEnum sexo : SexoEnum.values()) {
            if (sexo.getCodigo().equals(codigo)) {
                return sexo.getSigla();
            }
        }
        return null;
    }
}
