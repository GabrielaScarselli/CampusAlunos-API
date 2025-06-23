package com.apicampus.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apicampus.apirest.model.AlunoModel;
import com.apicampus.apirest.service.AlunoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarPorId(@PathVariable Long id) {
        Optional<AlunoModel> aluno = alunoService.buscarPorId(id);
        if (aluno.isPresent()){
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new AlunoModel(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody AlunoModel aluno) {
        String retorno = alunoService.salvar(aluno);
        try{
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<AlunoModel> listarTodos() {
        List<AlunoModel> listaTodoss = alunoService.buscarTodos();
        return listaTodoss;
    }
    @DeleteMapping(value= "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value="id")long id){
        Optional<AlunoModel> aluno = alunoService.buscarPorId(id);
        if(aluno.isPresent()){
        alunoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
