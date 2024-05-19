package org.milestone.events.elijah;

import java.util.Scanner;

public class Prenotazione {

	static void prenotazione(Evento evento) {
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
					Menu.interazione(evento, String.format("[SUCCESS] Hai prenotato con successo %s posti, ci sono %s posti disponibili.", numberOfBooking, (evento.getPostiTotale() - evento.getPostiPrenotati())));
				} else {
					Menu.interazione(evento, "[ERRORE] L'evento è già passato e non puoi effettuare delle prenotazioni");
				}
			}
		} else {
			Menu.interazione(evento);
		}
		scanner.close();
	}

}