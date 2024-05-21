package org.milestone.events.elijah;

import java.util.Scanner;

public class MenuAddEventi extends Menu {

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

	private static void displayMenuPrincipale() {
		displayHeaderConsole();
		System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET
				+ "Seleziona il tipo di evento\n" + "[1] Evento\n" + "[2] Concerto");
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
				principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
				
			}
		} catch (Exception e) {
			principale(ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
		}
	}

	public MenuAddEventi() {
		super();
	}

}