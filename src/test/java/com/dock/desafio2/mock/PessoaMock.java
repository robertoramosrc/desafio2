package com.dock.desafio2.mock;

import com.dock.desafio2.infra.repository.pessoa.PessoaEntity;
import com.dock.desafio2.service.pessoa.PessoaBO;

import java.time.LocalDate;

public class PessoaMock {

    public static final int ID_PESSOA_1 = 1;
    public static final String NOME_PESSOA_1 = "Amaury";
    public static final String CPF_PESSOA_1 = "12345678901";
    public static final LocalDate DATA_NASCIMENTO_PESSOA_1 = LocalDate.of(1999, 4, 2);

    public static PessoaBO buildPessoa1BO(){
        return PessoaBO.builder()
                .id(ID_PESSOA_1)
                .nome(NOME_PESSOA_1)
                .cpf(CPF_PESSOA_1)
                .dataNascimento(DATA_NASCIMENTO_PESSOA_1)
                .build();
    }
    public static PessoaBO buildPessoa1BOSemID(){
        return PessoaBO.builder()
                .nome(NOME_PESSOA_1)
                .cpf(CPF_PESSOA_1)
                .dataNascimento(DATA_NASCIMENTO_PESSOA_1)
                .build();
    }

    public static PessoaEntity buildPessoa1Entity(){
        return PessoaEntity.builder()
                .id(ID_PESSOA_1)
                .nome(NOME_PESSOA_1)
                .cpf(CPF_PESSOA_1)
                .dataNascimento(DATA_NASCIMENTO_PESSOA_1)
                .build();
    }
}
