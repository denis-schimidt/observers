package br.com.elo7.observers.model;

public class User implements Identifiable{
	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, nome=%s]", id, nome);
	}
}
