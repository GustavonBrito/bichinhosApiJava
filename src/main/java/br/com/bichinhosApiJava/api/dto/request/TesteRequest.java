package br.com.bichinhosApiJava.api.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TesteRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private int idade;
    @NotBlank
    private String cpf;
    @NotBlank
    private String altura;
}
