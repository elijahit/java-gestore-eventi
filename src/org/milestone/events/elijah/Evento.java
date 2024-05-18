package org.milestone.events.elijah;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento implements IEvento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati = 0;
	
	public Evento(String titolo, LocalDate data, int postiTotale) {
		this.data = data;
		this.titolo = titolo;
		this.postiTotale = postiTotale;	
		if(!checkDate(data)) System.out.println("[E (INSTANCE)] La data è precedente alla data corrente");
		if(postiTotale == 0) System.out.println("[E (INSTANCE)] I posti disponibili devono essere maggiori di 0");
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotale() {
		return postiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	@Override
	public void prenota() {
		if(checkDate(data) && postiPrenotati < postiTotale) {
			System.out.println(String.format("Hai prenotato con successo il posto %s, a presto!", postiPrenotati));
			postiPrenotati++;
		} else {
			if(!checkDate(data)) System.out.println("[E (PRENOTA)] L'evento non è più disponibile");
			else if(!(postiPrenotati < postiTotale)) System.out.println("[E (PRENOTA)] Non ci sono posti disponibili");
		}
		
	}

	@Override
	public void disdici() {
		if(checkDate(data) && postiPrenotati != 0) {
			System.out.println(String.format("Hai disdetto con successo il posto adesso ci sono %s posti disponibili.", (postiTotale - postiPrenotati+1)));
			postiPrenotati--;
		} else {
			if(!checkDate(data)) System.out.println("[E (DISDICI)] L'evento non è più disponibile");
			else if(!(postiPrenotati != 0)) System.out.println("[E (DISDICI)] Non ci sono prenotazioni da disdire");
		}
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ITALIAN);
		return String.format("[EVENTO] %s - %s",data.format(formatter), titolo);
	}
	
	private boolean checkDate(LocalDate data) {
		return (LocalDate.now().isBefore(data) ||  LocalDate.now().equals(data));
	}

}
