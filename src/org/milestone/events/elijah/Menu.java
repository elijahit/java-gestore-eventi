package org.milestone.events.elijah;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

	public static void interazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		menuString(evento);
		menuSwitch(evento, scanner);
		scanner.close();

	}

	public static void interazione(Evento evento, String response) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		menuString(evento);
		System.out.println();
		System.out.printf("[RESPONSE]: %s\n", response);
		menuSwitch(evento, scanner);
		scanner.close();

	}

	private static void menuString(Evento evento) {
		if (evento == null) {
			System.out.println(ConsoleColors.GREEN_BOLD +"   ____ _____ ____ _____ ___  ____  _____   _______     _______ _   _ _____ ___ " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD +"  / ___| ____/ ___|_   _/ _ \\|  _ \\| ____| | ____\\ \\   / / ____| \\ | |_   _|_ _|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + " | |  _|  _| \\___ \\ | || | | | |_) |  _|   |  _|  \\ \\ / /|  _| |  \\| | | |  | | " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + " | |_| | |___ ___) || || |_| |  _ <| |___  | |___  \\ V / | |___| |\\  | | |  | | " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + "  \\____|_____|____/ |_| \\___/|_| \\_\\_____| |_____|  \\_/  |_____|_| \\_| |_| |___|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		 _                  _ _  _       _     " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| |__  _   _    ___| (_)(_) __ _| |__  "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| '_ \\| | | |  / _ \\ | || |/ _` | '_ \\ "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| |_) | |_| | |  __/ | || | (_| | | | |"  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		|_.__/ \\__, |  \\___|_|_|/ |\\__,_|_| |_|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		       |___/          |__/             "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n" + ConsoleColors.RESET + "[1]: Istanzia evento");
		} else {
			System.out.println(ConsoleColors.GREEN_BOLD +"   ____ _____ ____ _____ ___  ____  _____   _______     _______ _   _ _____ ___ " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD +"  / ___| ____/ ___|_   _/ _ \\|  _ \\| ____| | ____\\ \\   / / ____| \\ | |_   _|_ _|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + " | |  _|  _| \\___ \\ | || | | | |_) |  _|   |  _|  \\ \\ / /|  _| |  \\| | | |  | | " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + " | |_| | |___ ___) || || |_| |  _ <| |___  | |___  \\ V / | |___| |\\  | | |  | | " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN_BOLD + "  \\____|_____|____/ |_| \\___/|_| \\_\\_____| |_____|  \\_/  |_____|_| \\_| |_| |___|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		 _                  _ _  _       _     " + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| |__  _   _    ___| (_)(_) __ _| |__  "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| '_ \\| | | |  / _ \\ | || |/ _` | '_ \\ "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		| |_) | |_| | |  __/ | || | (_| | | | |"  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		|_.__/ \\__, |  \\___|_|_|/ |\\__,_|_| |_|" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW + " 		       |___/          |__/             "  + ConsoleColors.RESET);
			System.out.println(ConsoleColors.YELLOW_BRIGHT + "MENU APPLICAZIONE: \n"+ ConsoleColors.RESET + "[1]: (Re)Istanzia evento\n" + "[2]: Aggiungi prenotazioni\n"
					+ "[3]: Disdici prenotazioni\n" + "[4]: Visualizza l'evento");
		}
	}

	private static void menuSwitch(Evento evento, Scanner scanner) {
		if (evento == null) {
			switch (scanner.nextInt()) {
			case 1:
				EventInitializer.initializer();
				break;
			default:
				Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}
		} else {
			switch (scanner.nextInt()) {
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
				interazione(evento, String.format(
						"\n[EVENTO: %s]\n" + "POSTI TOTALI: %s\n" + "POSTI PRENOTATI: %s\n" + "POSTI DISPONIBILI: %s\n"
								+ "DATA EVENTO: %s",
						evento.getTitolo(), evento.getPostiTotale(), evento.getPostiPrenotati(),
						(evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getData().format(formatter)));
				break;
			default:
				Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] La scelta effettuata non è disponibile" + ConsoleColors.RESET);
			}

		}
	}

	private static void spaceConsole() {
		for (int i = 0; i < 100; i++) {
			System.err.println();
		}
	}

}