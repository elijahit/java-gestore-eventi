package org.milestone.events.elijah;

import java.util.Scanner;

public class Menu {

	public static void interazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		System.out.println("MENU APPLICAZIONE: \n"
				+ "[1]: Ricrea evento\n"
				+ "[2]: Prenotazione\n"
				+ "[3]: Disdici prenotazioni");
		switch(scanner.nextInt()) {
			case 1: 
				EventInitializer.initializer();
				break;
			case 2:
				Prenotazione.prenotazione(evento);
				break;
			default: 
				System.out.println("[ERRORE] La scelta effettuata non è disponibile");
			
		}
		scanner.close();
		
	}

	public static void interazione(Evento evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		System.out.println("MENU APPLICAZIONE: \n"
				+ "[1]: Ricrea evento\n"
				+ "[2]: Prenotazione\n"
				+ "[3]: Disdici prenotazioni");
		System.out.println();
		System.out.printf("[RESPONSE]: %s\n", response);
		switch(scanner.nextInt()) {
			case 1: 
				EventInitializer.initializer();
				break;
			case 2:
				Prenotazione.prenotazione(evento);
				break;
			default: 
				System.out.println("[ERRORE] La scelta effettuata non è disponibile");
			
		}
		scanner.close();
		
	}
	private static void spaceConsole() {
		for(int i = 0; i < 100; i++) {
			System.err.println();
		}
	}

}