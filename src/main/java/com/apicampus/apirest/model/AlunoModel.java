package com.apicampus.apirest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel{
    private String campus;
	private String polo;
	private String email_institucional;
	private String coordenacao;
	private String curso;
	private String situacao;
	private String periodo_entrada;

    public AlunoModel(){}

    public AlunoModel(String campus, String polo, String email_institucional, String coordenacao, String curso,
    String situacao, String periodo_entrada){
        super();
        this.campus = campus;
        this.polo = polo;
        this.email_institucional = email_institucional;
        this.coordenacao = coordenacao;
        this.curso = curso;
        this.situacao = situacao;
        this.periodo_entrada = periodo_entrada;
    }
    	public AlunoModel(String nome_estudante, String coordenacao, String curso, String situacao,
			String periodo_entrada, String campus, String polo, String email_institucional, int idade, String sexo) {
		super(idade, sexo, nome_estudante);
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
        this.campus = campus;
        this.polo = polo;
        this.email_institucional = email_institucional;
	}
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    public String getPolo() {
        return polo;
    }
    public void setPolo(String polo) {
        this.polo = polo;
    }
    public String getEmail_institucional() {
        return email_institucional;
    }
    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }
    public String getCoordenacao() {
        return coordenacao;
    }
    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getPeriodo_entrada() {
        return periodo_entrada;
    }
    public void setPeriodo_entrada(String periodo_entrada) {
        this.periodo_entrada = periodo_entrada;
    }
    
}
