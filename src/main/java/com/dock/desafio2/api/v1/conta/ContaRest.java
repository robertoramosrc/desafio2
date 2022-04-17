package com.dock.desafio2.api.v1.conta;

import com.dock.desafio2.api.v1.conta.dto.ContaInputDTO;
import com.dock.desafio2.api.v1.conta.dto.ContaOutputDTO;
import com.dock.desafio2.infra.repository.conta.ContaConverter;
import com.dock.desafio2.service.conta.ContaBO;
import com.dock.desafio2.service.conta.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = ContaRest.CONTA_PATH)
@AllArgsConstructor
public class ContaRest {
    public static final String CONTA_PATH = "/desafio2/v1/contas";

    private final ContaService contaService;
    private final ContaConverter contaConverter;

    @ApiOperation(value = "Cria Conta Corrente")
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

    @ApiOperation(value = "Bloquear Conta Corrente")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    @PatchMapping("/{id}")
    public ResponseEntity<ContaOutputDTO> bloquearConta(
            @PathVariable("id") Integer idConta
    ) {

        return status(CREATED)
                .body(contaConverter.toContaOutputDTO(
                        contaService.bloquearConta(idConta)));
    }


}
