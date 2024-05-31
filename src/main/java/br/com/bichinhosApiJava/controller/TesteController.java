package br.com.bichinhosApiJava.controller;

import br.com.bichinhosApiJava.dto.request.TesteRequest;
import br.com.bichinhosApiJava.entity.TesteEntity;
import br.com.bichinhosApiJava.service.impl.TesteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class TesteController {
    @Autowired
    private TesteServiceImpl testeServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTesteEntityById(@PathVariable(value = "id") Long id){
        System.out.println(id);
        return ResponseEntity.ok(this.testeServiceImpl.getUserById(id));
    }
    @GetMapping
    public ResponseEntity<?> getTesteEntityAll(){
        return ResponseEntity.ok(this.testeServiceImpl.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntityById(@PathVariable(value = "id") Long id, @RequestBody @Valid TesteRequest testeRequest){
        TesteEntity testeEntity = new TesteEntity();
        testeEntity.setNome(testeRequest.getNome());
        testeEntity.setCpf(testeRequest.getCpf());
        testeEntity.setIdade(testeRequest.getIdade());
        testeEntity.setAltura(testeRequest.getAltura());

        return ResponseEntity.ok().body(this.testeServiceImpl.updateUserById(id, testeEntity));
    }

    @PostMapping
    public ResponseEntity<?> saveTesteEntity(@RequestBody @Valid TesteRequest testeRequest){
        TesteEntity testeEntity = new TesteEntity();
        testeEntity.setId(testeRequest.getId());
        testeEntity.setNome(testeRequest.getNome());
        testeEntity.setCpf(testeRequest.getCpf());
        testeEntity.setIdade(testeRequest.getIdade());
        testeEntity.setAltura(testeRequest.getAltura());

        return ResponseEntity.ok(this.testeServiceImpl.createTeste(testeEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTesteEntity(@PathVariable(value = "id") Long id){
        this.testeServiceImpl.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
