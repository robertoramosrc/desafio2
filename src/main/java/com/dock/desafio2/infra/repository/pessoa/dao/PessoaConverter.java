package com.dock.desafio2.infra.repository.pessoa.dao;

import com.dock.desafio2.service.pessoa.PessoaBO;
import org.springframework.stereotype.Component;

@Component
public class PessoaConverter {
    public PessoaBO toPessoaBO(PessoaEntity entity) {
        return PessoaBO.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getNome())
                .dataNascimento(entity.getDataNascimento())
                .build();
    }
}
