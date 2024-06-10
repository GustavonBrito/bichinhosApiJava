package br.com.bichinhosApiJava.dto.response;




import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TesteResponse {

    private String nome;

    private int idade;

    @JsonIgnore
    private String cpf;

    private String altura;
}
