package br.com.bichinhosApiJava.domain.service;

import br.com.bichinhosApiJava.domain.entity.TesteEntity;

import java.util.List;
import java.util.Optional;

public interface ICreateTesteService {
    TesteEntity createTeste(TesteEntity testeEntity);
    List<TesteEntity> getAllUsers();
    Optional<TesteEntity> getUserById(Long id);
    TesteEntity updateUserById(Long id, TesteEntity testeEntity);
}
