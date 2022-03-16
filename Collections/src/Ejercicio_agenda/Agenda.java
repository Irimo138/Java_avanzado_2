package Ejercicio_agenda;

import java.util.*;

public class Agenda {
	private Map<String, Integer[]> agenda;
	
	public final int MAX_ENTRADAS;

	public Agenda(int max_entradas) {
		MAX_ENTRADAS = max_entradas;
		agenda = new HashMap<String, Integer[]>();
	}
	
	public void addEntry(String nom, Integer[] num) {	
			agenda.put(nom, num);
		
	}

	public void existe(String nom) {
		Iterator<String> it = agenda.keySet().iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println();
			
			
			
		}
		
	}
		
	
	
	public static void main(String[] args) {
		Agenda ag = new Agenda(23);
		Integer[] numeros = new Integer[2];
		numeros[0] = 688824053;
		numeros[0] = 633469624;
		ag.addEntry("kaiku", numeros);
		ag.addEntry("Asistxo", numeros);
		ag.addEntry("Asistxo", numeros);
		ag.existe("kaiku");
	}
}

