package br.com.bichinhosApiJava.service;

import br.com.bichinhosApiJava.entity.TesteEntity;

import java.util.List;
import java.util.Optional;

public interface ICreateTesteService {
    TesteEntity createTeste(TesteEntity testeEntity);
    List<TesteEntity> getAllUsers();
    Optional<TesteEntity> getUserById(Long id);
    TesteEntity updateUserById(Long id, TesteEntity testeEntity);
    void deleteUserById(Long id);
}
