package com.dock.desafio2.mock;

import com.dock.desafio2.infra.repository.conta.ContaEntity;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.conta.TipoContaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.dock.desafio2.mock.PessoaMock.buildPessoa1BO;
import static com.dock.desafio2.mock.PessoaMock.buildPessoa1Entity;

public class ContaMock {

    public static final int ID_CONTA_1 = 1;
    public static final BigDecimal SALDO_CONTA_1 = new BigDecimal("10000.00");
    public static final BigDecimal LIMITE_SAQUE_DIARIO_CONTA_1 = new BigDecimal("50000.00");
    public static final LocalDateTime DATA_CRIACAO_CONTA_1 =
            LocalDateTime.of(2022, 4, 17, 20,19);

    public static ContaBO buildContaBO1Ativa(){
        return ContaBO.builder()
                .id(ID_CONTA_1)
                .pessoa(buildPessoa1BO())
                .saldo(SALDO_CONTA_1)
                .flagAtivo(Boolean.TRUE)
                .limiteSaqueDiario(LIMITE_SAQUE_DIARIO_CONTA_1)
                .tipoConta(TipoContaEnum.CORRENTE)
                .dataCriacao(DATA_CRIACAO_CONTA_1)
                .build();
    }

    public static ContaBO buildContaBOSemID(){
        return ContaBO.builder()
                .pessoa(buildPessoa1BO())
                .saldo(SALDO_CONTA_1)
                .flagAtivo(Boolean.TRUE)
                .limiteSaqueDiario(LIMITE_SAQUE_DIARIO_CONTA_1)
                .tipoConta(TipoContaEnum.CORRENTE)
                .dataCriacao(DATA_CRIACAO_CONTA_1)
                .build();
    }

    public static ContaEntity buildConta1AtivaEntityAntesDoSalvamento(){
        return ContaEntity.builder()
                .pessoa(buildPessoa1Entity())
                .saldo(SALDO_CONTA_1)
                .flagAtivo(Boolean.TRUE)
                .limiteSaqueDiario(LIMITE_SAQUE_DIARIO_CONTA_1)
                .tipoConta(TipoContaEnum.CORRENTE.getValor())
                .dataCriacao(DATA_CRIACAO_CONTA_1)
                .build();
    }

    public static ContaEntity buildConta1AtivaEntity(){
        return ContaEntity.builder()
                .pessoa(buildPessoa1Entity())
                .id(ID_CONTA_1)
                .saldo(SALDO_CONTA_1)
                .flagAtivo(Boolean.TRUE)
                .limiteSaqueDiario(LIMITE_SAQUE_DIARIO_CONTA_1)
                .tipoConta(TipoContaEnum.CORRENTE.getValor())
                .dataCriacao(DATA_CRIACAO_CONTA_1)
                .build();
    }

}
