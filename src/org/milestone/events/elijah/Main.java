package org.milestone.events.elijah;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BENVENUTO NEL GESTORE DI EVENTI");
		System.out.println("Iniziamo istanziando il tuo evento:");
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
		System.out.printf("L'evento è stato instanziato con successo:\n%s\n", evento);
		interazione(evento);
		
		

	}

	private static void interazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		spaceConsole();
		System.out.println("MENU APPLICAZIONE: \n"
				+ "[1]: Ricrea evento\n"
				+ "[2]: Prenotazione\n"
				+ "[3]: Disdici prenotazioni");
		switch(scanner.nextInt()) {
			case 1: 
				main(null);
				break;
			case 2:
				prenotazione(evento);
				break;
			default: 
				System.out.println("[ERRORE] La scelta effettuata non è disponibile");
			
		}
		interazione(evento);
		
	}

	private static void spaceConsole() {
		for(int i = 0; i < 3; i++) {
			System.err.println();
		}
	}

	private static void prenotazione(Evento evento) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[?] Vuoi effettuare delle prenotazione? Inserisci: Si o No");
		String responseBooking = scanner.nextLine();
		boolean booking = responseBooking.toLowerCase().equals("si") ? true : false;
		if(booking) {
			System.out.println("[?] Quante prenotazioni vuoi effettuare?");
			int numberOfBooking = scanner.nextInt();
			if(numberOfBooking > (evento.getPostiTotale() - evento.getPostiPrenotati())) {
				System.out.println(String.format("[!] Il numero di posti richiesti è maggiore dei posti disponbili. Ci sono %s posti disponibili", (evento.getPostiTotale() - evento.getPostiPrenotati())));
				prenotazione(evento);
			}
			else {
				if(evento.checkDate(evento.getData()) && evento.getPostiTotale() > 0) {					
					for (int i = 0; i < numberOfBooking; i++) {					
						evento.prenota();
					}
					System.out.println(String.format("[SUCCESS] Hai prenotato con successo %s posti, ci sono %s posti disponibili.", numberOfBooking, (evento.getPostiTotale() - evento.getPostiPrenotati())));
				} else {
					System.out.println("[ERRORE] L'evento è già passato e non puoi effettuare delle prenotazioni");
				}
			}
		}
	}


}
