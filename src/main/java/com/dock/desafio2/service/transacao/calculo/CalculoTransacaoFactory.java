package com.dock.desafio2.service.transacao.calculo;

import com.dock.desafio2.exceptions.NegocioException;
import com.dock.desafio2.service.transacao.TipoTransacaoEnum;
import org.springframework.stereotype.Component;

@Component
public class CalculoTransacaoFactory {

    public CalculoTransacao getCalculoTransacao(TipoTransacaoEnum tipoTransacao){

        switch (tipoTransacao){
            case CREDITO:
                return CalculoTransacaoDeposito.builder().build();

            case DEBITO:
                return CalculoTransacaoSaque.builder().build();

            case ESTORNO_CREDITO:
                return CalculoTransacaoEstornoCredito.builder().build();

            case ESTORNO_DEBITO:
                return CalculoTransacaoEstornoDebito.builder().build();

            default:
                throw new NegocioException("Tipo de transação não encontrado: " + tipoTransacao);
        }
    }
}
