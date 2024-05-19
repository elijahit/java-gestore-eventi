package org.milestone.events.elijah;

import java.time.LocalDate;
import java.util.Scanner;

public class EventInitializer {

	protected static void initializer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual'è il nome del tuo evento?");
		String title = scanner.nextLine();
		System.out.printf("Bene, il tuo evento si chiama: %s.\n"
				+ "Adesso inserisci il giorno in numero in cui si terrà il tuo evento (ex: 20):\n", title);
		int dayOfEvents = scanner.nextInt();
		System.out.println("Inserisci il mese in cui si terrà il tuo evento (ex 01):");
		int monthOfEvents = scanner.nextInt();
		System.out.println("Inserisci l'anno in cui si terrà il tuo evento (ex 2024):");
		int yearOfEvents = scanner.nextInt();
		System.out.println("Inserisci Il numero di posti che l'evento può contenere:");
		int slotOfEvents = scanner.nextInt();
		scanner.nextLine();
		
		Evento evento = new Evento(title, LocalDate.of(yearOfEvents, monthOfEvents, dayOfEvents), slotOfEvents);
		Menu.interazione(evento, String.format("L'evento è stato instanziato con successo:\n%s\n", evento));
		scanner.close();
	}

}