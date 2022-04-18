package com.dock.desafio2.api.v1.transacao.dto;

import com.dock.desafio2.service.transacao.TipoTransacaoEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class LinhaExtrato {
    private BigDecimal valor;
    private LocalDateTime dataTransacao;
    private TipoTransacaoEnum tipoTransacao;
}
