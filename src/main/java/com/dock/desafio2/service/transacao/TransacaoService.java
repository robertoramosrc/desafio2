package com.dock.desafio2.service.transacao;

import com.dock.desafio2.api.v1.transacao.dto.LinhaExtrato;
import com.dock.desafio2.api.v1.transacao.dto.PaginaExtrato;
import com.dock.desafio2.exceptions.NegocioException;
import com.dock.desafio2.infra.repository.transacao.TransacaoConverter;
import com.dock.desafio2.infra.repository.transacao.TransacaoRepository;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.conta.ContaService;
import com.dock.desafio2.service.transacao.calculo.CalculoTransacao;
import com.dock.desafio2.service.transacao.calculo.CalculoTransacaoFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final ContaService contaService;
    private final CalculoTransacaoFactory calculoTransacaoFactory;
    private final TransacaoConverter transacaoConverter;

    @Transactional
    public Long criarTransacao(TransacaoBO transacao) {

        ContaBO conta = contaService.buscarContaPorId(transacao.getConta().getId());
        validarConta(conta);

        BigDecimal novoSaldo = calcularSaldo(conta, transacao);
        validarSaldo(novoSaldo);
        conta.setSaldo(novoSaldo);

        transacao.setConta(conta);
        Long idTransacao = transacaoRepository.criarTransacao(transacao).getId();
        contaService.atualizarSaldo(conta);

        return idTransacao;
    }

    private void validarSaldo(BigDecimal novoSaldo) {
        if (BigDecimal.ZERO.compareTo(novoSaldo) > 0) {
            throw new NegocioException("Saldo insuficiente para realizar a transação");
        }
    }

    private BigDecimal calcularSaldo(ContaBO conta, TransacaoBO transacao) {
        CalculoTransacao calculoTransacao = calculoTransacaoFactory.getCalculoTransacao(transacao.getTipoTransacao());

        return calculoTransacao.calcularSaldoAposTransacao(conta, transacao);
    }

    private void validarConta(ContaBO conta) {
        if (conta == null) {
            throw new NegocioException("Conta inexistente");
        }
    }

    public PaginaExtrato consultarExtratoTransacoes(Integer idConta, LocalDate dataInicial, LocalDate dataFinal) {
        List<TransacaoBO> lancamentos =
                transacaoRepository.consultarExtratoTransacao(idConta, dataInicial, dataFinal);

        return PaginaExtrato.builder()
                .lancamentos(lancamentos.
                        stream()
                        .sorted(Comparator.comparing(TransacaoBO::getDataTransacao).reversed())
                        .map(transacaoConverter::toLinhaExtrato)
                        .collect(Collectors.toList()))
                .totalCreditos(calcularTotalCreditos(lancamentos))
                .totalDebitos(calcularTotalDebitos(lancamentos))
                .totalLancamentos(lancamentos.size())
                .build();
    }

    private BigDecimal calcularTotalCreditos(List<TransacaoBO> lancamentos) {
        return lancamentos
                .stream()
                .filter(identificaLancamentosDeCredito())
                .map(TransacaoBO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularTotalDebitos(List<TransacaoBO> lancamentos) {
        return lancamentos
                .stream()
                .filter(identificaLancamentosDeDebito())
                .map(TransacaoBO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Predicate<TransacaoBO> identificaLancamentosDeCredito() {
        return transacao -> TipoTransacaoEnum.CREDITO.equals(transacao.getTipoTransacao());
    }

    private Predicate<TransacaoBO> identificaLancamentosDeDebito() {
        return transacao -> TipoTransacaoEnum.DEBITO.equals(transacao.getTipoTransacao());
    }

}
