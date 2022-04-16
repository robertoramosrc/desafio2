package com.dock.desafio2.service.pessoa;

import com.dock.desafio2.infra.repository.pessoa.PessoaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {
    private final ModelMapper mapper;
    private final PessoaRepository pessoaRepository;

    public List<PessoaBO> buscarPessoas(){
        return pessoaRepository.buscarPessoas();
    }

}
