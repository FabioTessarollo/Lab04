package it.polito.tdp.lab04.model;

public class Corso implements Comparable<Corso> {
	
	public String codins;
	public int numeroCrediti;
	public String nome;
	public int periodoDidattico;
	
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}


	public String getCodins() {
		return codins;
	}


	public void setCodins(String codins) {
		this.codins = codins;
	}


	public int getNumeroCrediti() {
		return numeroCrediti;
	}


	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPeriodoDidattico() {
		return periodoDidattico;
	}


	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}


	@Override
	public int compareTo(Corso o) {
		return this.codins.compareTo(o.codins);
	}


	@Override
	public String toString() {
		return codins + " " + nome;
	}
	
	
	
	

}
