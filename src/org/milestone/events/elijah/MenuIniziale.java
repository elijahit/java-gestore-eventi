package org.milestone.events.elijah;

import java.time.LocalDate;
import java.util.Scanner;


public class MenuIniziale extends Menu {
	public final static ProgrammEventi evento = new ProgrammEventi("Programmazione");
	
	public static void principale() {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuPrincipale();
		menuPrincipale(scanner);
		scanner.close();
	}

	public static void principale(String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		displayMenuPrincipale();
		System.out.println();
		System.out.printf(ConsoleColors.YELLOW_BRIGHT + "[RESPONSE]: " + ConsoleColors.RESET + "%s\n", response);
		menuPrincipale(scanner);
		scanner.close();
	
	}

	private static void displayMenuPrincipale() {
		displayHeaderConsole();
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET
				+ "[1]: Aggiungi Evento\n" 
				+ "[2]: Vedi Eventi\n" 
				+ "[3]: Vedi Eventi (In data specifica)\n"
				+ "[4]: Vedi Programmazione\n"
				+ "[5]: Resetta la Programmazione");
	}
	private static void eventsByDate() {
		Scanner scanner = new Scanner(System.in);
		try {	
			Menu.spaceConsole();
			System.out.println("Inserisci il giorno di ricerca del tuo evento");
			int day = scanner.nextInt();
			System.out.println("Inserisci il mese di ricerca del tuo evento");
			int month = scanner.nextInt();
			System.out.println("Inserisci l'anno di ricerca del tuo evento");
			int year = scanner.nextInt();
			principale("\n" + evento.getEvents(LocalDate.of(year, month, day)));
		} catch (Exception e) {
			eventsByDate();
		}
		scanner.close();
		
	}

	private static void menuPrincipale(Scanner scanner) {
		try { 			
			switch (scanner.nextInt()) {
			case 1:
				MenuAddEventi.principale();
				break;
			case 2:
				principale("\n" + evento.getEvents());
				break;
			case 3:
				eventsByDate();
				break;
			case 4:
				principale("\n" + evento.getProgrammazione());
				break;
			case 5:
				evento.resetEvents();
				principale(ConsoleColors.GREEN + "[SUCCESS] La programmazione è stata resettata, nessun evento è più disponibile" + ConsoleColors.RESET);
				break;
			default:
				principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} catch (Exception e) {
			principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}
	
	}

}
