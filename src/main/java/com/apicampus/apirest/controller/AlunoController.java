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
import com.apicampus.apirest.model.PessoaModel;
import com.apicampus.apirest.service.AlunoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
    public ResponseEntity<Object> deletarPorID(@PathVariable(value="id")long id){
        Optional<AlunoModel> aluno = alunoService.buscarPorId(id);
        if(aluno.isPresent()){
        alunoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nome/{nomeEstudante}")
    public ResponseEntity<Object> buscarPorNomeEstudante(@PathVariable(value = "nomeEstudante") String nomeEstudante)
    {
        Optional<AlunoModel> nomeAluno = alunoService.buscarPorNomeEstudante(nomeEstudante);
        if(nomeAluno.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(nomeAluno, HttpStatus.OK);
        }
    }
    @GetMapping("/curso/{curso}")
    public List<AlunoModel> buscarPorCurso(@PathVariable(value = "curso") String curso)
    {
        List<AlunoModel> nomeAluno = alunoService.buscarPorCurso(curso);
        return nomeAluno;
    }
    @GetMapping("/turno/{turno}")
    public List<AlunoModel> buscarPorTurno(@PathVariable(value = "turno") String turno)
    {
        List<AlunoModel> nomeAluno = alunoService.buscarPorTurno(turno);
        return nomeAluno;
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AlunoModel> editar(@PathVariable(value = "id") long id, @Valid @RequestBody AlunoModel aluno) {
        Optional<AlunoModel> alunoAlteradoOptional= alunoService.buscarPorId(id);
        if(alunoAlteradoOptional.isPresent()){
            AlunoModel alunoAlterado = alunoAlteradoOptional.get();
            alunoAlterado.setNomeEstudante(aluno.getNomeEstudante());
            alunoAlterado.setIdade(aluno.getIdade());
            alunoAlterado.setSexo(aluno.getSexo());
            alunoAlterado.setCampus(aluno.getCampus());
            alunoAlterado.setPolo(aluno.getPolo());
            alunoAlterado.setEmail_institucional(aluno.getEmail_institucional());
            alunoAlterado.setCoordenacao(aluno.getCoordenacao());
            alunoAlterado.setCurso(aluno.getCurso());
            alunoAlterado.setSituacao(aluno.getSituacao());
            alunoAlterado.setPeriodo_entrada(aluno.getPeriodo_entrada());
            alunoAlterado.setTurno(aluno.getTurno());

            alunoService.salvar(alunoAlterado);
            return new ResponseEntity<AlunoModel>(alunoAlterado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
