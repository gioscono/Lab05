package it.polito.tdp.model;

public class Lettera {

	private char c;
	private int codice;
	
	public Lettera(Character c2, int codice) {
		this.c = c2;
		this.codice = codice;
	}

	public char getC() {
		return c;
	}

	public int getCodice() {
		return codice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
