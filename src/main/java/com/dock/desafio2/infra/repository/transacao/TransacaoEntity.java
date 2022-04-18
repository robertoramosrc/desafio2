package com.dock.desafio2.infra.repository.transacao;

import com.dock.desafio2.infra.repository.conta.ContaEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Data
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTransacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConta", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContaEntity conta;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "tipoTransacao")
    private String tipoTransacao;

    @CreationTimestamp
    @Column(name = "dataTransacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataTransacao;

}
