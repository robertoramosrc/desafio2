package com.dock.desafio2.api.v1.transacao.dto;

import com.dock.desafio2.service.transacao.TipoTransacaoEnum;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class TransacaoInputDTO {
    private Integer idConta;
    private BigDecimal valor;
    private TipoTransacaoEnum tipoTransacao;
}
