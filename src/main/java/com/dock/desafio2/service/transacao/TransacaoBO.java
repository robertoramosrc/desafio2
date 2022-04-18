package com.dock.desafio2.service.transacao;

import com.dock.desafio2.infra.repository.conta.ContaEntity;
import com.dock.desafio2.service.conta.ContaBO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class TransacaoBO {
    private Long id;
    private ContaBO conta;
    private BigDecimal valor;
    private TipoTransacaoEnum tipoTransacao;
    private LocalDateTime dataTransacao;
}
