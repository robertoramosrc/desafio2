package com.dock.desafio2.infra.repository.conta.DAO;

import com.dock.desafio2.infra.repository.pessoa.dao.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContaDAO extends JpaRepository<ContaEntity, Integer> {

    List<ContaEntity> findAllByPessoaAndTipoConta(@Param("pessoa") PessoaEntity pessoa,
                                                  @Param("tipoConta") Integer tipoConta);
}
