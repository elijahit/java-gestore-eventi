package org.milestone.events.elijah;

import java.time.LocalDate;
import java.util.Scanner;

public class EventoInitializer {

	protected static void initializer() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Qual'è il nome del tuo evento?");
			String title = scanner.nextLine();
			System.out.printf("Bene, il tuo evento si chiama: %s.\n"
					+ "Adesso inserisci il giorno in numero in cui si terrà il tuo evento (ex: 20):\n", title);
			int dayOfEvents = scanner.nextInt();
			if (dayOfEvents > 31 || dayOfEvents < 1)
				initializer(ConsoleColors.RED + "[!] Il giorno dev'essere compresa tra 1 e 31" + ConsoleColors.RESET);
			System.out.println("Inserisci il mese in cui si terrà il tuo evento (ex 01):");
			int monthOfEvents = scanner.nextInt();
			if (monthOfEvents > 12 || monthOfEvents < 1)
				initializer(ConsoleColors.RED + "[!] Il mese dev'essere compreso tra 1 e 12" + ConsoleColors.RESET);
			System.out.println("Inserisci l'anno in cui si terrà il tuo evento (ex 2024):");
			int yearOfEvents = scanner.nextInt();
			if (yearOfEvents > 2099 || yearOfEvents < 2000)
				initializer(ConsoleColors.RED + "[!] L'anno dev'essere compreso tra 2000 e 2099" + ConsoleColors.RESET);
			System.out.println("Inserisci Il numero di posti che l'evento può contenere:");
			int slotOfEvents = scanner.nextInt();
			scanner.nextLine();

			Evento evento = new Evento(title, LocalDate.of(yearOfEvents, monthOfEvents, dayOfEvents), slotOfEvents);
			MenuIniziale.evento.addEvents(evento);
			String errori = "";
			if (!evento.checkDate(evento.getData()))
				errori += "[E (INSTANCE)] La data è precedente alla data corrente\n";
			if (evento.getPostiTotale() == 0)
				errori += "[E (INSTANCE)] I posti disponibili devono essere maggiori di 0";
			MenuInterazione.principale(evento,
					String.format("L'evento è stato instanziato con successo:\n%s\n%s", evento, errori));
			scanner.close();
		} catch (Exception e) {
			initializer("Abbiamo rilevato un errore, ricontrolla i dati inseriti.");
		}
	}

	private static void initializer(String errore) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println(String.format("%s", errore));
			System.out.println("Qual'è il nome del tuo evento?");
			String title = scanner.nextLine();
			System.out.printf("Bene, il tuo evento si chiama: %s.\n"
					+ "Adesso inserisci il giorno in numero in cui si terrà il tuo evento (ex: 20):\n", title);
			int dayOfEvents = scanner.nextInt();
			if (dayOfEvents > 31 || dayOfEvents < 1)
				initializer(ConsoleColors.RED + "[!] Il giorno dev'essere compresa tra 1 e 31" + ConsoleColors.RESET);
			System.out.println("Inserisci il mese in cui si terrà il tuo evento (ex 01):");
			int monthOfEvents = scanner.nextInt();
			if (monthOfEvents > 12 || monthOfEvents < 1)
				initializer(ConsoleColors.RED + "[!] Il mese dev'essere compreso tra 1 e 12" + ConsoleColors.RESET);
			System.out.println("Inserisci l'anno in cui si terrà il tuo evento (ex 2024):");
			int yearOfEvents = scanner.nextInt();
			if (yearOfEvents > 2099 || yearOfEvents < 2000)
				initializer(ConsoleColors.RED + "[!] L'anno dev'essere compreso tra 2000 e 2099" + ConsoleColors.RESET);
			System.out.println("Inserisci Il numero di posti che l'evento può contenere:");
			int slotOfEvents = scanner.nextInt();
			scanner.nextLine();

			Evento evento = new Evento(title, LocalDate.of(yearOfEvents, monthOfEvents, dayOfEvents), slotOfEvents);
			MenuIniziale.evento.addEvents(evento);
			String errori = "";
			if (!evento.checkDate(evento.getData()))
				errori += "[E (INSTANCE)] La data è precedente alla data corrente\n";
			if (evento.getPostiTotale() == 0)
				errori += "[E (INSTANCE)] I posti disponibili devono essere maggiori di 0";
			MenuInterazione.principale(evento,
					String.format("L'evento è stato instanziato con successo:\n%s\n%s", evento, errori));
			scanner.close();
		} catch (Exception e) {
			initializer("Abbiamo rilevato un errore, ricontrolla i dati inseriti.");
		}
	}

}