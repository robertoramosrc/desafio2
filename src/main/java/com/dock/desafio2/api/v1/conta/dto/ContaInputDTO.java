package com.dock.desafio2.api.v1.conta.dto;

import com.dock.desafio2.service.conta.TipoContaEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class ContaInputDTO {
    private BigDecimal saldo;
    private BigDecimal limiteSaqueDiario;
    private TipoContaEnum tipoConta;
    private Integer idPessoa;
    private Boolean flagAtivo;
}

