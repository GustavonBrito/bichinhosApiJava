package br.com.bichinhosApiJava.dto.response;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TesteResponse {

    private Long id;

    private String nome;

    private int idade;

    private String cpf;

    private String altura;
}
