package org.milestone.events.elijah;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private double prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotale, LocalTime ora, double prezzo) {
		super(titolo, data, postiTotale);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
	
	public String getOraFormattata() {
		DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm", Locale.ITALIAN);
		return "" + getOra().format(formatterHour);
		
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getPrezzoFormattato() {
		DecimalFormat formatterPrice = new DecimalFormat("#00.00");  
		return "" + formatterPrice.format(getPrezzo()) + "€";
	}

	@Override
	public String toString() {
		return String.format("[CONCERTO] %s - %s | %s - %s", super.getDataFormattata(), getOraFormattata(), super.getTitolo(), getPrezzoFormattato());
	}
}
