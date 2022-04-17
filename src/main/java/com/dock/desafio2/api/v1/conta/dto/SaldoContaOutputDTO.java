package com.dock.desafio2.api.v1.conta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class SaldoContaOutputDTO {
    private BigDecimal saldo;
}
