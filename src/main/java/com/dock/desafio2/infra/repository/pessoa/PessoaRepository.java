package com.dock.desafio2.infra.repository.pessoa;

import com.dock.desafio2.infra.repository.pessoa.dao.PessoaDAO;
import com.dock.desafio2.service.pessoa.PessoaBO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PessoaRepository {

    private final PessoaDAO pessoaDAO;
    private final ModelMapper mapper;

    public List<PessoaBO> buscarPessoas() {
        return pessoaDAO.findAll()
                .stream()
                .map(pessoaEntity -> mapper.map(pessoaEntity, PessoaBO.class))
                .collect(Collectors.toList());
    }

}
