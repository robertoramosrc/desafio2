package com.dock.desafio2.service.pessoa;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class PessoaBO {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
}
