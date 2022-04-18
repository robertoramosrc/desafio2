package com.dock.desafio2.api.v1.pessoa;

import com.dock.desafio2.api.v1.pessoa.dto.PessoaOutputDTO;
import com.dock.desafio2.service.pessoa.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = PessoaRest.PESSOA_PATH)
@AllArgsConstructor
public class PessoaRest {
    public static final String PESSOA_PATH = "/desafio2/v1/pessoas";

    private final PessoaService pessoaService;
    private final ModelMapper mapper;

    @ApiOperation(value = "Consulta Pessoas")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping()
    public ResponseEntity<List<PessoaOutputDTO>> buscarPessoas() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pessoaService.buscarPessoas()
                        .stream()
                        .map(pessoaBO -> mapper.map(pessoaBO, PessoaOutputDTO.class))
                        .collect(Collectors.toList())
                );
    }

}
