package br.ucsal.model;

public class Recurso {
	
	private Long id;
	private String nome;
	private Boolean ativo;
	
	public Recurso() {}
	public Recurso(String nome, Boolean ativo) {
		this.nome = nome;
		this.ativo = ativo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
