package com.dock.desafio2.infra.repository.pessoa.dao;

import com.dock.desafio2.infra.repository.pessoa.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PessoaDAO extends JpaRepository<PessoaEntity, Integer> {

}
