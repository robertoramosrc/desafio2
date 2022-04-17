package com.dock.desafio2.service.conta;

import com.dock.desafio2.exceptions.NegocioException;
import com.dock.desafio2.infra.repository.conta.ContaRepository;
import com.dock.desafio2.service.pessoa.PessoaBO;
import com.dock.desafio2.service.pessoa.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {
    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;

    public ContaBO criarConta(ContaBO conta){
        PessoaBO pessoa = pessoaService.buscarPessoaPeloId(conta.getPessoa().getId());

        validaPessoa(pessoa, conta);
        validaConta(conta);

        conta.setPessoa(pessoa);
        return contaRepository.criarConta(conta);
    }

    private void validaConta(ContaBO conta) {
        List<ContaBO> contas = buscarContasPorPessoaETipo(conta.getPessoa(), conta.getTipoConta().getValor());
        if(contas != null && !contas.isEmpty()){
            throw new NegocioException("Conta do mesmo tipo já cadastrada anteriormente para a mesma pessoa");
        }
    }

    private void validaPessoa(PessoaBO pessoa, ContaBO conta) {
        if(pessoa == null){
            throw new NegocioException(String.format("Pessoa com id %s não existe na base de dados", conta.getPessoa().getId()));
        }
    }

    private List<ContaBO> buscarContasPorPessoaETipo(PessoaBO pessoa, Integer tipoConta){
        return contaRepository.buscarContasPorPessoaETipo(pessoa, tipoConta);
    }
}
