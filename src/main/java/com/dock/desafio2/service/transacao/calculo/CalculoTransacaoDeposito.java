package com.dock.desafio2.service.transacao.calculo;

import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.transacao.TransacaoBO;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class CalculoTransacaoDeposito implements CalculoTransacao{

    @Override
    public BigDecimal calcularSaldoAposTransacao(ContaBO conta, TransacaoBO transacao) {
        return conta.getSaldo().add(transacao.getValor());
    }

}
