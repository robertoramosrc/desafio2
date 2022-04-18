package com.dock.desafio2.infra.repository.transacao;

import com.dock.desafio2.exceptions.NegocioException;
import com.dock.desafio2.infra.repository.transacao.DAO.TransacaoDAO;
import com.dock.desafio2.service.transacao.TransacaoBO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Slf4j
public class TransacaoRepository {
    private final TransacaoDAO transacaoDAO;
    private final TransacaoConverter transacaoConverter;

    public TransacaoBO criarTransacao(TransacaoBO transacao) {
        try {

            TransacaoEntity transacaoEntity = transacaoConverter.toTransacaoEntity(transacao);
            transacaoEntity.setDataTransacao(LocalDateTime.now());

            return transacaoConverter.toTransacaoBO(transacaoDAO.save(transacaoEntity));

        } catch (Exception e) {
            log.error("Erro Criando Transacao {} {}", transacao, e.getCause().getMessage());
            throw new NegocioException("Erro criando Transacao - ver log da aplicação para mais detalhes");
        }
    }

    public List<TransacaoBO> consultarExtratoTransacao(Integer idConta,
                                                       LocalDate dataInicial,
                                                       LocalDate dataFinal) {
        try {
            List<TransacaoEntity> transacoes = transacaoDAO.findAllByContaAndDataTransacao(
                    idConta,
                    LocalDateTime.of(dataInicial, LocalTime.of(0, 0)),
                    LocalDateTime.of(dataFinal, LocalTime.of(23, 59, 59)));

            return transacoes
                    .stream()
                    .map(transacaoConverter::toTransacaoBO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Erro consultando extrato: " + e.getCause().getMessage());
            throw new NegocioException("Erro consultando extrato - ver log da aplicação para mais detalhes");
        }
    }

}
