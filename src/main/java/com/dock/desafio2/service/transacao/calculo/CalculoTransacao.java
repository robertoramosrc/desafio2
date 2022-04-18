package com.dock.desafio2.service.transacao.calculo;

import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.transacao.TransacaoBO;

import java.math.BigDecimal;

public interface CalculoTransacao {
    public BigDecimal calcularSaldoAposTransacao(ContaBO conta, TransacaoBO transacao);
}
