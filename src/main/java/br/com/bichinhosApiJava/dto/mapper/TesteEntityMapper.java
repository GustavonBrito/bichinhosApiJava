package br.com.bichinhosApiJava.dto.mapper;

import br.com.bichinhosApiJava.dto.request.TesteRequest;
import br.com.bichinhosApiJava.dto.response.TesteResponse;
import br.com.bichinhosApiJava.entity.TesteEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TesteEntityMapper {

    public TesteEntity transformRequestToEntity(TesteRequest testeRequest){
        TesteEntity testeEntity = new TesteEntity();

        testeEntity.setNome(testeRequest.getNome());
        testeEntity.setCpf(testeRequest.getCpf());
        testeEntity.setIdade(testeRequest.getIdade());
        testeEntity.setAltura(testeRequest.getAltura());
        return testeEntity;
    };

    public TesteResponse transformEntityToResponse(TesteEntity testeEntity){
        TesteResponse testeResponse = new TesteResponse();
        testeResponse.setNome(testeEntity.getNome());
        testeResponse.setAltura(testeEntity.getAltura());
        testeResponse.setIdade(testeEntity.getIdade());
        return testeResponse;
    }
}
