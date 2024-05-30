package br.com.bichinhosApiJava.domain.repository;


import br.com.bichinhosApiJava.domain.entity.TesteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateTestRepository extends JpaRepository<TesteEntity, Long> {
}
