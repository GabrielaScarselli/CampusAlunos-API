package com.apicampus.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.apicampus.apirest.model.AlunoModel;
import com.apicampus.apirest.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public String salvar(AlunoModel aluno){
        try{
            alunoRepository.saveAndFlush(aluno);
            return "Salvo com sucesso chega de errar";
        } catch (Exception e){
            return e.getMessage();
        }
    }
    public Optional<AlunoModel> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }
    public List<AlunoModel> buscarTodos(){
        return alunoRepository.findAll();
    }
        public String deletar(Long id){
            alunoRepository.deleteById(id);
            return "Deletado";
    }
    public Optional<AlunoModel> buscarPorNomeEstudante(String nomeEstudante){
        return alunoRepository.findByNomeEstudante(nomeEstudante);
    }
    public List<AlunoModel> buscarPorCurso(String curso){
        return alunoRepository.findByCurso(curso);
    }
    public List<AlunoModel> buscarPorTurno(String turno){
        return alunoRepository.findByTurno(turno);
    }
}
