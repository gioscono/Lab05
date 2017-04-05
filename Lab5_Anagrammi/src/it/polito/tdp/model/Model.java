package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	String parolaIniziale;
	List<Lettera> listaLettere;
	List<String> anagrammil;
	List<Anagramma> anagrammi;
	
	public List<Anagramma> calcolaAnagrammi(String text) {
		
		parolaIniziale = text;
		char[] lettere = text.toCharArray();
		listaLettere = new ArrayList<Lettera>();
		
		for(int i=0; i<lettere.length; i++){
			Lettera l = new Lettera(lettere[i], i);
			listaLettere.add(l);
		}
		
		List<Anagramma> soluzione = this.risolvi();
		return soluzione;
	}

	
	public List<Anagramma> risolvi(){
		List<Lettera> caratteri = new ArrayList<Lettera>();
		anagrammil = new ArrayList<String>();
		anagrammi = new ArrayList<Anagramma>();
		aggiungi(caratteri, 0, anagrammil);
		return anagrammi;
	}


	private void aggiungi(List<Lettera> caratteri, int livello, List<String> anagrammil) {
		AnagrammaDAO dao = new AnagrammaDAO();
		if(caratteri.size()== parolaIniziale.length()){
			if(!anagrammil.contains(calcolaParola(caratteri))){
				anagrammil.add(calcolaParola(caratteri));
				anagrammi.add(new Anagramma(calcolaParola(caratteri),dao.isCorrect(calcolaParola(caratteri))));
			}
		}
		
		for(Lettera l : listaLettere){
			if(!caratteri.contains(l)){
				caratteri.add(l);
				aggiungi(caratteri, livello+1, anagrammil);
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
