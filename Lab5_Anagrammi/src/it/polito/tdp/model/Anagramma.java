package it.polito.tdp.model;

public class Anagramma {

	private String anagramma;
	private boolean esiste;
	
	public Anagramma(String anagramma, boolean esiste) {
		this.anagramma = anagramma;
		this.esiste = esiste;
	}

	public String getAnagramma() {
		return anagramma;
	}

	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}

	public boolean isEsiste() {
		return esiste;
	}

	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	}
	

	
	
	
}
