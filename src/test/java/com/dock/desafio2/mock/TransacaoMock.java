package com.dock.desafio2.mock;

import com.dock.desafio2.infra.repository.transacao.TransacaoEntity;
import com.dock.desafio2.service.transacao.TipoTransacaoEnum;
import com.dock.desafio2.service.transacao.TransacaoBO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.dock.desafio2.mock.ContaMock.buildConta1AtivaEntity;
import static com.dock.desafio2.mock.ContaMock.buildContaBO1Ativa;

public class TransacaoMock {
    public static final BigDecimal VALOR_TRANSACAO = new BigDecimal("100.00");

    public static final LocalDateTime DATA_TRANSACAO =
            LocalDateTime.of(2022, 4, 17, 20,19);


    public static TransacaoBO buildTransacaoBO(){
        return TransacaoBO.builder()
                .tipoTransacao(TipoTransacaoEnum.CREDITO)
                .dataTransacao(DATA_TRANSACAO)
                .conta(buildContaBO1Ativa())
                .valor(VALOR_TRANSACAO)
                .build();
    }

    public static TransacaoEntity buildTransacaoEntity(){
        return TransacaoEntity.builder()
                .tipoTransacao(TipoTransacaoEnum.CREDITO.getValor())
                .dataTransacao(DATA_TRANSACAO)
                .conta(buildConta1AtivaEntity())
                .valor(VALOR_TRANSACAO)
                .build();
    }

}
