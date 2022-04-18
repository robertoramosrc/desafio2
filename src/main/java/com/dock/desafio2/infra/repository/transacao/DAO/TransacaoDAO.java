package com.dock.desafio2.infra.repository.transacao.DAO;

import com.dock.desafio2.infra.repository.transacao.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransacaoDAO extends JpaRepository<TransacaoEntity, Long> {

    @Query(value = "select t.* " +
            "         from transacao t " +
            "        inner join conta c on t.id_conta = c.id_conta " +
            "       WHERE t.id_conta = :idConta " +
            "         and t.data_transacao between :dataInicial AND :dataFinal",
            nativeQuery = true)
    List<TransacaoEntity> findAllByContaAndDataTransacao(@Param("idConta") Integer conta,
                                                         @Param("dataInicial") LocalDateTime dataInicial,
                                                         @Param("dataFinal") LocalDateTime dataFinal);
}
