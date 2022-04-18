package com.dock.desafio2.api.v1.transacao;

import com.dock.desafio2.api.v1.transacao.dto.PaginaExtrato;
import com.dock.desafio2.api.v1.transacao.dto.TransacaoInputDTO;
import com.dock.desafio2.api.v1.transacao.dto.TransacaoOutputDTO;
import com.dock.desafio2.infra.repository.transacao.TransacaoConverter;
import com.dock.desafio2.service.transacao.TransacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = TransacaoRest.TRANSACAO_PATH )
@AllArgsConstructor
public class TransacaoRest {
    public static final String TRANSACAO_PATH = "/desafio2/v1/transacoes";

    private final TransacaoService transacaoService;
    private final TransacaoConverter transacaoConverter;

    @ApiOperation(value = "Cria Transação")
    @ApiResponses({@ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @PostMapping
    public ResponseEntity<TransacaoOutputDTO> criarTransacao(
            @Valid @RequestBody TransacaoInputDTO input
    ) {

        return status(CREATED)
                .body(TransacaoOutputDTO.builder()
                        .id(transacaoService.criarTransacao(transacaoConverter.toTransacaoBO(input))).build());
    }

    @ApiOperation(value = "Extrato de Transações por Período")
    @ApiResponses({@ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @GetMapping
    public ResponseEntity<PaginaExtrato> consultarExtratoTransacoes(
            @RequestParam("conta") Integer idConta,
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
            ) {

        return status(OK)
                .body(transacaoService.consultarExtratoTransacoes(idConta, dataInicial, dataFinal));
    }

}
