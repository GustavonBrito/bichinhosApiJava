package br.com.bichinhosApiJava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TesteException extends RuntimeException {

   public TesteException (String message) {super(message);}

}
