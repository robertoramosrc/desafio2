package com.dock.desafio2.service.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TipoTransacaoEnum {
    CREDITO("C"),
    DEBITO("D"),
    ESTORNO_CREDITO("EC"),
    ESTORNO_DEBITO("ED");

    private final String valor;

    public static TipoTransacaoEnum convert(String valor) {
        return Arrays.stream(values())
                .filter(tipoTransacao -> tipoTransacao.getValor().equals(valor))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Valor %s de Tipo de Transação Invalido", valor)));
    }

    public static TipoTransacaoEnum from(final Enum<?> e) {
        return e == null ? null : valueOf(e.name());
    }
}
