package com.dock.desafio2.infra.repository.conta;

import com.dock.desafio2.exceptions.NegocioException;
import com.dock.desafio2.infra.repository.conta.DAO.ContaDAO;
import com.dock.desafio2.infra.repository.conta.DAO.ContaEntity;
import com.dock.desafio2.infra.repository.pessoa.dao.PessoaEntity;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.pessoa.PessoaBO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Slf4j
public class ContaRepository {
    private final ContaDAO contaDAO;
    private final ContaConverter contaConverter;
    private final ModelMapper mapper;

    public ContaBO criarConta(ContaBO conta) {
        try {

            ContaEntity contaEntity = contaConverter.toEntity(conta);

            contaEntity.setDataCriacao(LocalDateTime.now());

            return contaConverter.toBo(contaDAO.save(contaEntity));

        } catch (Exception e) {
            log.error("Erro Criando Conta {} {}", conta, e.getCause().getMessage());
            throw new NegocioException("Erro criando Conta - ver log da aplicação para mais detalhes");
        }
    }

    public List<ContaBO> buscarContasPorPessoaETipo(PessoaBO pessoa, Integer tipoConta) {
        try {

            List<ContaEntity> contas = contaDAO.findAllByPessoaAndTipoConta(
                    mapper.map(pessoa, PessoaEntity.class), tipoConta);

            return contas
                    .stream()
                    .map(contaConverter::toBo)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Erro buscando Contas por idPessoa {} e tipo de conta {} {}",
                    pessoa, tipoConta, e.getCause().getMessage());

            throw new NegocioException("Erro buscando Contas por idPessoa e tipo de conta - ver log da aplicação para mais detalhes");
        }
    }

    public ContaBO buscarContaPorId(Integer idConta) {
        try {

            Optional<ContaEntity> contaEntity = contaDAO.findById(idConta);
            return contaEntity.map(contaConverter::toBo).orElse(null);


        } catch (Exception e) {
            log.error("Erro buscando Contas por id {} {}",
                    idConta, e.getCause().getMessage());

            throw new NegocioException("Erro buscando Contas por ID - ver log da aplicação para mais detalhes");
        }
    }

    public ContaBO atualizarConta(ContaBO conta) {
        try {

            ContaEntity contaEntity = contaConverter.toEntity(conta);

            return contaConverter.toBo(contaDAO.save(contaEntity));

        } catch (Exception e) {
            log.error("Erro atualizando Conta {} {}", conta, e.getCause().getMessage());
            throw new NegocioException("Erro atualizando Conta - ver log da aplicação para mais detalhes");
        }
    }

}
