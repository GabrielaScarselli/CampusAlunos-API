package com.apicampus.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicampus.apirest.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
    Optional<AlunoModel> findByNomeEstudante(String nomeEstudante);
    List<AlunoModel> findByCurso(String curso);
    List<AlunoModel> findByTurno(String turno); //a outra maneira de bbuscar aqui
}
