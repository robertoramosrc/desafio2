package com.dock.desafio2.api.v1.pessoa;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class PessoaInputDTO {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
}
