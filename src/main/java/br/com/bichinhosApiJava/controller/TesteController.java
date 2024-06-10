package br.com.bichinhosApiJava.controller;

import br.com.bichinhosApiJava.dto.mapper.TesteEntityMapper;
import br.com.bichinhosApiJava.dto.request.TesteRequest;
import br.com.bichinhosApiJava.entity.TesteEntity;
import br.com.bichinhosApiJava.service.impl.TesteServiceImpl;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {
    @Autowired
    private TesteServiceImpl testeServiceImpl;
    @Autowired
    private TesteEntityMapper testeEntityMapper;
    @GetMapping("/{id}")
    public ResponseEntity<?> getTesteEntityById(@PathVariable(value = "id") Long id){
        System.out.println(id);
        return ResponseEntity.ok(this.testeServiceImpl.getUserById(id));
    }
    @ApiResponse(responseCode = "200", description = "Usuarios localizados !")
    @GetMapping
    public ResponseEntity<?> getTesteEntityAll(){
        return ResponseEntity.ok(this.testeServiceImpl.getAllUsers());
    }

    @ApiResponse(responseCode = "200", description = "Usuario atualizado !")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntityById(@PathVariable(value = "id") Long id, @RequestBody TesteRequest testeRequest){
        Optional<TesteRequest> testeRequestOptional = Optional.ofNullable(testeRequest);
        TesteEntity testeEntity = new TesteEntity();
        testeEntity.setNome(testeRequestOptional.get().getNome());
        testeEntity.setCpf(testeRequestOptional.get().getCpf());
        testeEntity.setIdade(testeRequestOptional.get().getIdade());
        testeEntity.setAltura(testeRequestOptional.get().getAltura());

        return ResponseEntity.ok().body(this.testeServiceImpl.updateUserById(id, testeEntity));
    }


    @ApiResponse(responseCode = "400", description = "CPF invalido !")
    @PostMapping
    public ResponseEntity<?> saveTesteEntity(@RequestBody @Valid TesteRequest testeRequest, Throwable error){
            TesteEntity testeEntity = this.testeEntityMapper.transformRequestToEntity(testeRequest);
            TesteEntity testeCreated = this.testeServiceImpl.createTeste(testeEntity);
            return ResponseEntity.ok().body(this.testeEntityMapper.transformEntityToResponse(testeCreated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTesteEntity(@PathVariable(value = "id") Long id){
        this.testeServiceImpl.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
