package com.dock.desafio2.infra.repository.transacao;

import com.dock.desafio2.api.v1.transacao.dto.LinhaExtrato;
import com.dock.desafio2.api.v1.transacao.dto.TransacaoInputDTO;
import com.dock.desafio2.infra.repository.conta.ContaConverter;
import com.dock.desafio2.infra.repository.transacao.TransacaoEntity;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.transacao.TipoTransacaoEnum;
import com.dock.desafio2.service.transacao.TransacaoBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransacaoConverter {
    private final ContaConverter contaConverter;

    public TransacaoBO toTransacaoBO(TransacaoEntity entity){
        return TransacaoBO.builder()
                .conta(contaConverter.toBo(entity.getConta()))
                .dataTransacao(entity.getDataTransacao())
                .id(entity.getId())
                .valor(entity.getValor())
                .tipoTransacao(TipoTransacaoEnum.convert(entity.getTipoTransacao()))
                .build();
    }

    public TransacaoEntity toTransacaoEntity(TransacaoBO bo){
        return TransacaoEntity.builder()
                .conta(contaConverter.toEntity(bo.getConta()))
                .dataTransacao(bo.getDataTransacao())
                .id(bo.getId())
                .valor(bo.getValor())
                .tipoTransacao(bo.getTipoTransacao().getValor())
                .build();
    }

    public TransacaoBO toTransacaoBO(TransacaoInputDTO inputDTO){
        return TransacaoBO.builder()
                .conta(ContaBO.builder().id(inputDTO.getIdConta()).build())
                .valor(inputDTO.getValor())
                .tipoTransacao(inputDTO.getTipoTransacao())
                .build();
    }

    public LinhaExtrato toLinhaExtrato(TransacaoBO bo){
        return LinhaExtrato.builder()
                .dataTransacao(bo.getDataTransacao())
                .valor(bo.getValor())
                .tipoTransacao(bo.getTipoTransacao())
                .build();
    }

}
