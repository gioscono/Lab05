package it.polito.tdp.model;

import java.util.*;

public class Model {

	String parolaIniziale;
	List<Lettera> listaLettere;
	
	public List<String> calcolaAnagrammi(String text) {
		
		parolaIniziale = text;
		char[] lettere = text.toCharArray();
		listaLettere = new ArrayList<Lettera>();
		
		for(int i=0; i<lettere.length; i++){
			Lettera l = new Lettera(lettere[i], i);
			listaLettere.add(l);
		}
		
		List<String> soluzione = this.risolvi();
		return soluzione;
	}

	
	public List<String> risolvi(){
		List<Lettera> caratteri = new ArrayList<Lettera>();
		List<String> anagrammi = new ArrayList<String>();
		aggiungi(caratteri, 0, anagrammi);
		return anagrammi;
	}


	private void aggiungi(List<Lettera> caratteri, int livello, List<String> anagrammi) {
		if(caratteri.size()== parolaIniziale.length()){
			if(!anagrammi.contains(calcolaParola(caratteri))){
				anagrammi.add(calcolaParola(caratteri));
			}
		}
		
		for(Lettera l : listaLettere){
			if(caratteri.contains(l)){
				caratteri.add(l);
				aggiungi(caratteri, livello+1, anagrammi);
				caratteri.remove(l);
			}
		}
		
	}


	private String calcolaParola(List<Lettera> caratteri) {
		String ris = "";
		for(Lettera l: caratteri){
			ris += l.getC();
		}
		return ris;
	}
	
}
