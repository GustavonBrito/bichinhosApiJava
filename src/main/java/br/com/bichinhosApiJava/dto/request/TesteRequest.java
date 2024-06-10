package br.com.bichinhosApiJava.dto.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Getter
@Setter
public class TesteRequest {
    @Size(min = 5,max = 60, message = "o nome não pode ter menos que 5 caracteres ou mais que 60")
    @NotBlank
    private String nome;
    @Min(value = 18, message =  "A idade minima é de 18 anos")
    @NotNull
    private int idade;
    @CPF(message = "É necessário a inserção de um CPF valido")
    @NotBlank
    private String cpf;
    @NotBlank
    private String altura;
}
