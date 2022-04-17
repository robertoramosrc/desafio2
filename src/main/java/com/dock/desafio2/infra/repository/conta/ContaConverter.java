package com.dock.desafio2.infra.repository.conta;

import com.dock.desafio2.api.v1.conta.dto.ContaInputDTO;
import com.dock.desafio2.api.v1.conta.dto.ContaOutputDTO;
import com.dock.desafio2.infra.repository.conta.DAO.ContaEntity;
import com.dock.desafio2.infra.repository.pessoa.dao.PessoaEntity;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.conta.TipoContaEnum;
import com.dock.desafio2.service.pessoa.PessoaBO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContaConverter {

    private final ModelMapper mapper;

    public ContaEntity toEntity(ContaBO bo){
        return  ContaEntity.builder()
                .tipoConta(bo.getTipoConta().getValor())
                .limiteSaqueDiario(bo.getLimiteSaqueDiario())
                .saldo(bo.getSaldo())
                .pessoa(mapper.map(bo.getPessoa(), PessoaEntity.class))
                .flagAtivo(bo.getFlagAtivo())
                .build();
    }

    public ContaBO toBo(ContaEntity entity){
        return  ContaBO.builder()
                .tipoConta(TipoContaEnum.convert(entity.getTipoConta()))
                .limiteSaqueDiario(entity.getLimiteSaqueDiario())
                .saldo(entity.getSaldo())
                .id(entity.getId())
                .pessoa(mapper.map(entity.getPessoa(), PessoaBO.class))
                .dataCriacao(entity.getDataCriacao())
                .flagAtivo(entity.getFlagAtivo())
                .build();
    }

    public ContaOutputDTO toContaOutputDTO(ContaBO bo){
        return  ContaOutputDTO.builder()
                .tipoConta(bo.getTipoConta())
                .limiteSaqueDiario(bo.getLimiteSaqueDiario())
                .saldo(bo.getSaldo())
                .id(bo.getId())
                .pessoa(bo.getPessoa())
                .dataCriacao(bo.getDataCriacao())
                .flagAtivo(bo.getFlagAtivo())
                .build();
    }

    public ContaBO toBo(ContaInputDTO dto){
        return  ContaBO.builder()
                .tipoConta(dto.getTipoConta())
                .limiteSaqueDiario(dto.getLimiteSaqueDiario())
                .saldo(dto.getSaldo())
                .pessoa(criaPessoaComSeuIdApenas(dto))
                .flagAtivo(dto.getFlagAtivo())
                .build();
    }

    private PessoaBO criaPessoaComSeuIdApenas(ContaInputDTO dto) {
        return PessoaBO.builder().id(dto.getIdPessoa()).build();
    }

}
