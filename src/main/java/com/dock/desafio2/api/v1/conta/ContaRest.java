package com.dock.desafio2.api.v1.conta;

import com.dock.desafio2.api.v1.conta.dto.ContaInputDTO;
import com.dock.desafio2.api.v1.conta.dto.ContaOutputDTO;
import com.dock.desafio2.api.v1.conta.dto.SaldoContaOutputDTO;
import com.dock.desafio2.infra.repository.conta.ContaConverter;
import com.dock.desafio2.service.conta.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = ContaRest.CONTA_PATH)
@AllArgsConstructor
public class ContaRest {
    public static final String CONTA_PATH = "/desafio2/v1/contas";

    private final ContaService contaService;
    private final ContaConverter contaConverter;

    @ApiOperation(value = "Cria Conta")
    @ApiResponses({@ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @PostMapping
    public ResponseEntity<ContaOutputDTO> criarConta(
            @Valid @RequestBody ContaInputDTO input
    ) {

        return status(CREATED)
                .body(contaConverter.toContaOutputDTO(
                        contaService.criarConta(contaConverter.toBo(input))));
    }

    @ApiOperation(value = "Alterar Situação da Conta")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @PatchMapping("/{id}")
    public ResponseEntity<ContaOutputDTO> alterarSituacaoConta(
            @PathVariable("id") Integer idConta,
            @RequestParam(value = "flagAtivo", required = false) Boolean novoFlagAtivo
    ) {

        return status(OK)
                .body(contaConverter.toContaOutputDTO(
                        contaService.alterarSituacaoDaConta(idConta, novoFlagAtivo)));
    }

    @ApiOperation(value = "Consultar Saldo da Conta")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @GetMapping("/{id}/saldo")
    public ResponseEntity<SaldoContaOutputDTO> consultarSaldoDaConta(
            @PathVariable("id") Integer idConta
    ) {

        return status(OK)
                .body(SaldoContaOutputDTO.builder()
                        .saldo(contaService.consultarSaldoDaConta(idConta))
                        .build());
    }

}
