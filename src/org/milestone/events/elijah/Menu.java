package org.milestone.events.elijah;

import java.util.Scanner;

public class Menu {

	public static void principale() {
		Scanner scanner = new Scanner(System.in);
		displayMenuPrincipale();
		menuPrincipale(scanner);
		scanner.close();
	}

	public static void principale(String response) {
		Scanner scanner = new Scanner(System.in);
		displayMenuPrincipale();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuPrincipale(scanner);
		scanner.close();
	}

	public static void interazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuInterazione();
		menuInterazione(evento, scanner);
		scanner.close();

	}

	public static void interazione(Evento evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuInterazione();
		System.out.println();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuInterazione(evento, scanner);
		scanner.close();

	}

	public static void interazione(Concerto evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuInterazione();
		menuInterazione(evento, scanner);
		scanner.close();

	}

	public static void interazione(Concerto evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuInterazione();
		System.out.println();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuInterazione(evento, scanner);
		scanner.close();

	}

	private static void displayMenuPrincipale() {
		displayHeaderConsole();
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET
				+ "Seleziona il tipo di evento\n" + "[1] Evento\n" + "[2] Concerto");
	}

	private static void displayMenuInterazione() {
		displayHeaderConsole();
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET
				+ "[1]: (Re)Istanzia evento\n" + "[2]: Aggiungi prenotazioni\n" + "[3]: Disdici prenotazioni\n"
				+ "[4]: Visualizza l'evento");
	}

	private static void menuPrincipale(Scanner scanner) {
		try {
			switch (scanner.nextInt()) {
			case 1:
				EventoInitializer.initializer();
				break;
			case 2:
				ConcertoInitializer.initializer();
				break;
			default:
				Menu.principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
				
			}
		} catch (Exception e) {
			principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}
	}

	private static void menuInterazione(Evento evento, Scanner scanner) {
		try { 			
			switch (scanner.nextInt()) {
			case 1:
				EventoInitializer.initializer();
				break;
			case 2:
				Prenotazione.aggiungiPrenotazioni(evento);
				break;
			case 3:
				Prenotazione.disdiciPrenotazione(evento);
				break;
			case 4:
				interazione(evento,
						String.format(
								"\n[EVENTO: %s]\n" + "POSTI TOTALI: %s\n" + "POSTI PRENOTATI: %s\n"
										+ "POSTI DISPONIBILI: %s\n" + "DATA EVENTO: %s",
										evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(),
										(evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getDataFormattata()));
				break;
			default:
				Menu.interazione(evento,
						ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} catch (Exception e) {
			interazione(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}

	}

	private static void menuInterazione(Concerto evento, Scanner scanner) {
		try {			
			switch (scanner.nextInt()) {
			case 1:
				ConcertoInitializer.initializer();
				break;
			case 2:
				Prenotazione.aggiungiPrenotazioni(evento);
				break;
			case 3:
				Prenotazione.disdiciPrenotazione(evento);
				break;
			case 4:
				interazione(evento, String.format(
						"\n[EVENTO: %s]\n" + "POSTI TOTALI: %s\n" + "POSTI PRENOTATI: %s\n" + "POSTI DISPONIBILI: %s\n"
								+ "DATA EVENTO: %s\n" + "ORA EVENTO: %s\n" + "PREZZO EVENTO: %s",
								evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(),
								(evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getDataFormattata(),
								evento.getOraFormattata(), evento.getPrezzoFormattato()));
				break;
			default:
				Menu.interazione(evento,
						ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} catch (Exception e) {
			interazione(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}

	}

	private static void spaceConsole() {
		for (int i = 0; i < 100; i++) {
			System.err.println();
		}
	}

	private static void displayHeaderConsole() {
		System.out.println(ConsoleColors.GREEN_BOLD
				+ "   ____ _____ ____ _____ ___  ____  _____   _______     _______ _   _ _____ ___ "
				+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD
				+ "  / ___| ____/ ___|_   _/ _ \\|  _ \\| ____| | ____\\ \\   / / ____| \\ | |_   _|_ _|"
				+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD
				+ " | |  _|  _| \\___ \\ | || | | | |_) |  _|   |  _|  \\ \\ / /|  _| |  \\| | | |  | | "
				+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD
				+ " | |_| | |___ ___) || || |_| |  _ <| |___  | |___  \\ V / | |___| |\\  | | |  | | "
				+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD
				+ "  \\____|_____|____/ |_| \\___/|_| \\_\\_____| |_____|  \\_/  |_____|_| \\_| |_| |___|"
				+ ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.YELLOW + " 		 _                  _ _  _       _     " + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.YELLOW + " 		| |__  _   _    ___| (_)(_) __ _| |__  " + ConsoleColors.RESET);
		System.out.println(
				ConsoleColors.YELLOW + " 		| '_ \\| | | |  / _ \\ | || |/ _` | '_ \\ " + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.YELLOW + " 		| |_) | |_| | |  __/ | || | (_| | | | |" + ConsoleColors.RESET);
		System.out.println(
				ConsoleColors.YELLOW + " 		|_.__/ \\__, |  \\___|_|_|/ |\\__,_|_| |_|" + ConsoleColors.RESET);
		System.out
				.println(ConsoleColors.YELLOW + " 		       |___/          |__/             " + ConsoleColors.RESET);
	}

}