package com.apicampus.apirest.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.GenerationType;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpessoa;
    @NotBlank
    @Column(name = "nome_estudante")
    private String nomeEstudante;
    @NotNull
    @Min(value= 18)
    @Max(value= 90)
	private int idade;
    @NotBlank
	private String sexo;

    public PessoaModel(){}

    public PessoaModel(int idade, String sexo, String nomeEstudante){
        super();
        this.nomeEstudante = nomeEstudante;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Long getIdPessoa() {
        return idpessoa;
    }
    public void setIdPessoa(Long idPessoa) {
        this.idpessoa = idPessoa;
    }
    public String getNomeEstudante() {
        return nomeEstudante;
    }
    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
