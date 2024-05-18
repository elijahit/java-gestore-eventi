package org.milestone.events.elijah;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Evento evento = new Evento("Test", LocalDate.of(2024, 05, 18), 10);
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

	}

}
