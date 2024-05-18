package org.milestone.events.elijah;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Evento evento = new Evento("Test", LocalDate.of(2023, 05, 18), 0);
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.disdici();
		evento.disdici();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		evento.prenota();
		System.out.println(evento);

	}

}
