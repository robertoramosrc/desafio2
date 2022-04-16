package com.dock.desafio2.api.v1.conta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = ContaRest.CONTA_PATH)
@Api(value = "Conta")
public class ContaRest {

    public static final String CONTA_PATH = "/desafio2/v1";

    @ApiOperation(value = "Cria Conta Corrente")
    @ApiResponses({@ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/contas")
    public ResponseEntity<Void> enviarBorderoParaAnalise() {
        return status(CREATED).build();
    }

}
