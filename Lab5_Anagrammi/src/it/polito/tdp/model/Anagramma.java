package it.polito.tdp.model;

public class Anagramma {

	private String anagramma;
	private boolean esiste;
	
	public Anagramma(String anagramma) {
		this.anagramma = anagramma;
		this.esiste = false;
	}
	
	public void setEsiste(boolean esiste){
		this.esiste = esiste;
	}
	
	
}
