package org.milestone.events.elijah;

import java.time.LocalDate;

public class Evento implements IEvento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati = 0;
	
	public Evento(String titolo, LocalDate data, int postiTotale) {
		this.titolo = titolo;
		this.data = data;
		this.postiTotale = postiTotale;
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
		if(checkDate() && postiPrenotati < postiTotale) {
			System.out.println(String.format("Hai prenotato con successo il posto %s, a presto!", postiPrenotati));
			postiPrenotati++;
		} else {
			System.out.println("Non abbiamo altri posti disponibili per questo evento.");
		}
		
	}

	@Override
	public void disdici() {
		if(checkDate() && postiPrenotati != 0) {
			System.out.println(String.format("Hai disdetto con successo il posto adesso ci sono %s posti disponibili.", (postiTotale - postiPrenotati+1)));
			postiPrenotati--;
		} else {
			System.out.println("Non ci sono prenotazioni da disdire.");
		}
		
	}
	
	private boolean checkDate() {
		return (LocalDate.now().isBefore(data) ||  LocalDate.now().equals(data));
	}

}
