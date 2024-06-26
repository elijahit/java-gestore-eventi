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
	
	public String getDataFormattata() {
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALIAN);
		return "" + getData().format(formatterDate);
		
	}

	public int getPostiTotale() {
		return postiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	@Override
	public boolean prenota(int prenotati) {
		if(checkDate(data) && postiPrenotati < postiTotale) {
			postiPrenotati += prenotati;
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean disdici(int prenotazioniDisdette) {
		if(checkDate(data) && postiPrenotati != 0) {
			postiPrenotati -= prenotazioniDisdette;
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ITALIAN);
		return String.format("[EVENTO] %s - %s",data.format(formatter), titolo);
	}
	
	public boolean checkDate(LocalDate data) {
		return (LocalDate.now().isBefore(data) ||  LocalDate.now().equals(data));
	}

}
