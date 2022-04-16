package com.dock.desafio2.api.v1.pessoa;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class PessoaOutputDTO {
    private Integer Id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDateTime dataCriacao;
}
