package com.dock.desafio2.service.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TipoContaEnum {
    CORRENTE(1),
    INVESTIMENTO(2);

    private final Integer valor;

    public static TipoContaEnum convert(Integer valor) {
        return Arrays.stream(values())
                .filter(tipoConta -> tipoConta.getValor().equals(valor))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Valor %s de Tipo de Conta Invalido", valor)));
    }

    public static TipoContaEnum from(final Enum<?> e) {
        return e == null ? null : valueOf(e.name());
    }
}
