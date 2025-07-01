package com.apicampus.apirest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel{
    @NotBlank
    private String campus;
	private String polo;
    @NotBlank
	private String email_institucional;
    @NotBlank
	private String coordenacao;
    @NotBlank
	private String curso;
    @NotBlank
	private String situacao;
    @NotBlank
	private String periodo_entrada;
    @NotBlank
    private String turno;

    public AlunoModel(){}

    public AlunoModel(String nomeEstudante, int idade, String sexo, String campus, String polo, String email_institucional, String coordenacao, String curso,
    String situacao, String periodo_entrada, String turno){
        super(idade, sexo, nomeEstudante);
        this.campus = campus;
        this.polo = polo;
        this.email_institucional = email_institucional;
        this.coordenacao = coordenacao;
        this.curso = curso;
        this.situacao = situacao;
        this.periodo_entrada = periodo_entrada;
        this.turno = turno;
    }
    	public AlunoModel(String nomeEstudante, String coordenacao, String curso, String situacao,
			String periodo_entrada, String campus, String polo, String email_institucional, int idade, String sexo, String turno) {
		super(idade, sexo, nomeEstudante);
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
        this.campus = campus;
        this.polo = polo;
        this.email_institucional = email_institucional;
        this.turno = turno;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
