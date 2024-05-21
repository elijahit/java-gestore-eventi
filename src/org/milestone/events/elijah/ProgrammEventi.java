package org.milestone.events.elijah;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		eventi = new ArrayList<>();
	}
	
	public void addEvents(Evento evento) {
		eventi.add(evento);
	}
	
	public String getEvents() {
		String events = "";
		if(eventi.size() > 0) {			
			for(Evento e: eventi) {
				events += e +"\n";
			}
		} else {
			events = "Nessun evento disponibile";
		}
		return events;
	}
	
	public String getEvents(LocalDate date) {
		String events = "";
		if(eventi.size() > 0) {			
			for(Evento e: eventi) {
				if(date.equals(e.getData())) {					
					events += e +"\n";
				}
			}
		} else {
			events = "Nessun evento disponibile";
		}
		return events;
	}
	
	public int getEventsSize() {
		return eventi.size();
	}
	
	public void resetEvents() {
		eventi = new ArrayList<>();
	}
	
	public String getProgrammazione() {
		String resolveProgrammazione = "";
		List<Evento> eventiSorted = new ArrayList<>();
		eventiSorted.addAll(eventi);
		eventiSorted.sort(Comparator.comparing(Evento::getData));
		for(Evento e: eventiSorted) {
			resolveProgrammazione += String.format("%s - %s\n", e.getDataFormattata(), e.getTitolo());
		}
		if(eventiSorted.size() == 0) return "Nessun evento disponibile";
		return resolveProgrammazione;
		
	}
}
 