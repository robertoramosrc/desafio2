package com.dock.desafio2.api.v1.transacao.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class PaginaExtrato {
    private Integer totalLancamentos;
    private BigDecimal totalCreditos;
    private BigDecimal totalDebitos;
    private List<LinhaExtrato> lancamentos;
}
