package org.milestone.events.elijah;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

	public static void interazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		menuString();
		menuSwitch(evento, scanner);
		scanner.close();
		
	}


	public static void interazione(Evento evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		menuString();
		System.out.println();
		System.out.printf("[RESPONSE]: %s\n", response);
		menuSwitch(evento, scanner);
		scanner.close();
		
	}


	private static void menuString() {
		System.out.println("MENU APPLICAZIONE: \n"
				+ "[1]: Ricrea evento\n"
				+ "[2]: Aggiungi prenotazioni\n"
				+ "[3]: Disdici prenotazioni\n"
				+ "[4]: Visualizza l'evento");
	}
	
	private static void menuSwitch(Evento evento, Scanner scanner) {
		switch(scanner.nextInt()) {
			case 1: 
				EventInitializer.initializer();
				break;
			case 2:
				Prenotazione.aggiungiPrenotazioni(evento);
				break;
			case 3:
				Prenotazione.disdiciPrenotazione(evento);
				break;
			case 4: 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ITALIAN);
				interazione(evento, String.format("\n[EVENTO: %s]\n"
						+ "POSTI TOTALI: %s\n"
						+ "POSTI PRENOTATI: %s\n"
						+ "POSTI DISPONIBILI: %s\n"
						+ "DATA EVENTO: %s", evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(), (evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getData().format(formatter)));
				break;
			default: 
				System.out.println("[ERRORE] La scelta effettuata non è disponibile");
			
		}
	}
	
	private static void spaceConsole() {
		for(int i = 0; i < 100; i++) {
			System.err.println();
		}
	}

}