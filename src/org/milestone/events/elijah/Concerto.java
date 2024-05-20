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

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm", Locale.ITALIAN);
		DecimalFormat formatterPrice = new DecimalFormat("#00.00");   
		return super.toString() + " | ORE: " + getOra().format(formatterHour) + " | PREZZO: " + formatterPrice.format(getPrezzo());
	}
}
