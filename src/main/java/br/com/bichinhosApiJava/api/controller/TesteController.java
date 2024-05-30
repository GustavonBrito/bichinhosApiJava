package br.com.bichinhosApiJava.api.controller;

import br.com.bichinhosApiJava.api.dto.request.TesteRequest;

import br.com.bichinhosApiJava.domain.entity.TesteEntity;
import br.com.bichinhosApiJava.domain.service.impl.CreateTesteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/teste")
public class TesteController {
    @Autowired
    private CreateTesteServiceImpl createTesteServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTesteEntityById(@PathVariable(value = "id") Long id){
        System.out.println(id);
        return ResponseEntity.ok(this.createTesteServiceImpl.getUserById(id));
    }
    @GetMapping
    public ResponseEntity<?> getTesteEntityAll(){
        return ResponseEntity.ok(this.createTesteServiceImpl.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntityById(@PathVariable(value = "id") Long id, @RequestBody TesteRequest testeRequest){
        TesteEntity testeEntity = new TesteEntity();
        testeEntity.setNome(testeRequest.getNome());
        testeEntity.setCpf(testeRequest.getCpf());
        testeEntity.setIdade(testeRequest.getIdade());
        testeEntity.setAltura(testeRequest.getAltura());

        return ResponseEntity.ok().body(this.createTesteServiceImpl.updateUserById(id, testeEntity));
    }

    @PostMapping
    public ResponseEntity<?> saveTesteEntity(@RequestBody TesteRequest testeRequest){
        TesteEntity testeEntity = new TesteEntity();
        testeEntity.setId(testeRequest.getId());
        testeEntity.setNome(testeRequest.getNome());
        testeEntity.setCpf(testeRequest.getCpf());
        testeEntity.setIdade(testeRequest.getIdade());
        testeEntity.setAltura(testeRequest.getAltura());

        return ResponseEntity.ok(this.createTesteServiceImpl.createTeste(testeEntity));
    }
}
