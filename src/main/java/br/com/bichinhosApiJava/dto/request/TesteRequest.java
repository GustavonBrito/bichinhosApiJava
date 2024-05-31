package br.com.bichinhosApiJava.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Getter
@Setter
public class TesteRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private int idade;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String altura;
}
