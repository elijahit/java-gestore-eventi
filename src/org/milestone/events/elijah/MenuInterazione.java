package org.milestone.events.elijah;

import java.util.Scanner;

public class MenuInterazione extends Menu {

	public static void principale(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuPrincipale();
		menuPrincipale(evento, scanner);
		scanner.close();
	
	}

	public static void principale(Evento evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuPrincipale();
		System.out.println();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuPrincipale(evento, scanner);
		scanner.close();
	
	}

	public static void principale(Concerto evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuPrincipale();
		menuPrincipale(evento, scanner);
		scanner.close();
	
	}

	public static void principale(Concerto evento, String response) {
		Scanner scanner = new Scanner(System.in);
		displayMenuPrincipale();
		System.out.println();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuPrincipale(evento, scanner);
		scanner.close();
	
	}

	private static void displayMenuPrincipale() {
		displayHeaderConsole();
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET
				+ "[1]: Aggiungi prenotazioni\n" + "[2]: Disdici prenotazioni\n"
				+ "[3]: Visualizza l'evento\n"
				+ "[4]: Ritorna al menu principale");
	}

	private static void menuPrincipale(Evento evento, Scanner scanner) {
		try { 			
			switch (scanner.nextInt()) {
			case 1:
				Prenotazione.aggiungiPrenotazioni(evento);
				break;
			case 2:
				Prenotazione.disdiciPrenotazione(evento);
				break;
			case 3:
				principale(evento,
						String.format(
								"\n[EVENTO: %s]\n" + "POSTI TOTALI: %s\n" + "POSTI PRENOTATI: %s\n"
										+ "POSTI DISPONIBILI: %s\n" + "DATA EVENTO: %s",
										evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(),
										(evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getDataFormattata()));
				break;
			case 4:
				MenuIniziale.principale();
				break;
			default:
				MenuInterazione.principale(evento,
						ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} catch (Exception e) {
			principale(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}
	
	}

	private static void menuPrincipale(Concerto evento, Scanner scanner) {
		try {			
			switch (scanner.nextInt()) {
			case 1:
				Prenotazione.aggiungiPrenotazioni(evento);
				break;
			case 2:
				Prenotazione.disdiciPrenotazione(evento);
				break;
			case 3:
				principale(evento, String.format(
						"\n[EVENTO: %s]\n" + "POSTI TOTALI: %s\n" + "POSTI PRENOTATI: %s\n" + "POSTI DISPONIBILI: %s\n"
								+ "DATA EVENTO: %s\n" + "ORA EVENTO: %s\n" + "PREZZO EVENTO: %s",
								evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(),
								(evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getDataFormattata(),
								evento.getOraFormattata(), evento.getPrezzoFormattato()));
				break;
			case 4:
				MenuIniziale.principale();
				break;
			default:
				MenuInterazione.principale(evento,
						ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} catch (Exception e) {
			principale(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}
	
	}

}