package br.com.bichinhosApiJava.service.impl;

import br.com.bichinhosApiJava.entity.TesteEntity;
import br.com.bichinhosApiJava.repository.ICreateTestRepository;
import br.com.bichinhosApiJava.service.ICreateTesteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesteServiceImpl implements ICreateTesteService {

    @Autowired
    private ICreateTestRepository iCreateTestRepository;
    @Override
    public TesteEntity createTeste(TesteEntity testeEntity) {
        return this.iCreateTestRepository.save(testeEntity);
    }

    @Override
    public List<TesteEntity> getAllUsers() {
        return this.iCreateTestRepository.findAll();
    }

    @Override
    public Optional<TesteEntity> getUserById(Long id) {
        return this.iCreateTestRepository.findById(id);
    }

    @Override
    public TesteEntity updateUserById(Long id, TesteEntity testeEntity) {
        Optional<TesteEntity> entityToUpdate = this.iCreateTestRepository.findById(id);

        TesteEntity existentTesteEntity = entityToUpdate.orElseThrow(() ->
        new EntityNotFoundException("Entity with ID " + id + " not found."));
        if (testeEntity.getNome() != null){
            existentTesteEntity.setNome(testeEntity.getNome());
        }
        existentTesteEntity.setCpf(testeEntity.getCpf());
        existentTesteEntity.setIdade(testeEntity.getIdade());
        existentTesteEntity.setAltura(testeEntity.getAltura());

        return this.iCreateTestRepository.save(existentTesteEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        this.iCreateTestRepository.deleteById(id);
    }
}
