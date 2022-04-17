package com.dock.desafio2.api.v1.conta.dto;

import com.dock.desafio2.service.conta.TipoContaEnum;
import com.dock.desafio2.service.pessoa.PessoaBO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class ContaOutputDTO {
    private Integer id;
    private PessoaBO pessoa;
    private BigDecimal saldo;
    private BigDecimal limiteSaqueDiario;
    private TipoContaEnum tipoConta;
    private LocalDateTime dataCriacao;
    private Boolean flagAtivo;
}
