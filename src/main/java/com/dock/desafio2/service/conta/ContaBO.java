package com.dock.desafio2.service.conta;

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
public class ContaBO {
    private Integer id;
    private PessoaBO pessoa;
    private BigDecimal saldo;
    private Boolean flagAtivo;
    private BigDecimal limiteSaqueDiario;
    private TipoContaEnum tipoConta;
    private LocalDateTime dataCriacao;
}
