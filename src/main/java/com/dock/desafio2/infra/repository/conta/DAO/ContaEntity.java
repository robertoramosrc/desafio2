package com.dock.desafio2.infra.repository.conta.DAO;

import com.dock.desafio2.infra.repository.pessoa.dao.PessoaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "conta")
@Data
@Builder
@EqualsAndHashCode
@ToString
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idConta")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PessoaEntity pessoa;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "limiteSaqueDiario")
    private BigDecimal limiteSaqueDiario;

    @Column(name = "flagAtivo")
    private Boolean flagAtivo;

    @Column(name = "tipoConta")
    private Integer tipoConta;

    @CreationTimestamp
    @Column(name = "dataCriacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCriacao;

}
