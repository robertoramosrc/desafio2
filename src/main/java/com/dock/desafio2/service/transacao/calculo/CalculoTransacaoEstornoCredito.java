package com.dock.desafio2.service.transacao.calculo;

import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.transacao.TransacaoBO;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
public class CalculoTransacaoEstornoCredito implements CalculoTransacao{

    @Override
    public BigDecimal calcularSaldoAposTransacao(ContaBO conta, TransacaoBO transacao) {
        return conta.getSaldo().subtract(transacao.getValor());
    }
    
}
