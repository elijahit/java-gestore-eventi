package org.milestone.events.elijah;

import java.util.Scanner;

public class Prenotazione {

	static void aggiungiPrenotazioni(Evento evento) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("[?] Vuoi effettuare delle prenotazione? Inserisci: Si o No");
			String responseBooking = scanner.nextLine();
			boolean booking = responseBooking.toLowerCase().equals("si") ? true : false;
			if(booking) {
				System.out.println("[?] Quante prenotazioni vuoi effettuare?");
				int numberOfBooking = scanner.nextInt();
				if(numberOfBooking > (evento.getPostiTotale() - evento.getPostiPrenotati())) {
					System.out.println(String.format(ConsoleColors.RED + "[!] Il numero di posti richiesti è maggiore dei posti disponbili. Ci sono %s posti disponibili" + ConsoleColors.RESET, (evento.getPostiTotale() - evento.getPostiPrenotati())));
					aggiungiPrenotazioni(evento);
				}
				else {
					if(evento.checkDate(evento.getData()) && evento.getPostiTotale() > 0) {									
						evento.prenota(numberOfBooking);
						Menu.interazione(evento, String.format(ConsoleColors.GREEN + "[SUCCESS] Hai prenotato con successo %s posti, ci sono %s posti disponibili." + ConsoleColors.RESET, numberOfBooking, (evento.getPostiTotale() - evento.getPostiPrenotati())));
					} else {
						Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] L'evento è già passato e non puoi effettuare delle prenotazioni." + ConsoleColors.RESET);
					}
				}
			} else {
				Menu.interazione(evento);
			}
			scanner.close();
		} catch (Exception e) {
			Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] Abbiamo rilevato un errore ricontrolla i dati inseriti, assicurati di inserire un numero e non una stringa." + ConsoleColors.RESET);
		}
	}
	
	static void disdiciPrenotazione(Evento evento) {
		try {		
			Scanner scanner = new Scanner(System.in);
			System.out.println("[?] Vuoi disdire delle prenotazione? Inserisci: Si o No");
			String responseBooking = scanner.nextLine();
			boolean booking = responseBooking.toLowerCase().equals("si") ? true : false;
			if(booking) {
				System.out.println("[?] Quante prenotazioni vuoi disdire?");
				int numberOfBooking = scanner.nextInt();
				if(numberOfBooking > evento.getPostiPrenotati()) {
					System.out.println(String.format(ConsoleColors.RED + "[!] Il numero di posti richiesti è minore dei posti prenotati. Ci sono %s posti prenotati." + ConsoleColors.RESET, (evento.getPostiPrenotati())));
					disdiciPrenotazione(evento);
				}
				else {
					if(evento.checkDate(evento.getData()) && evento.getPostiPrenotati() > 0) {									
						evento.disdici(numberOfBooking);
						Menu.interazione(evento, String.format(ConsoleColors.GREEN + "[SUCCESS] Hai disdetto con successo %s posti, ci sono %s posti disponibili e %s posti prenotati." + ConsoleColors.RESET, numberOfBooking, (evento.getPostiTotale() - evento.getPostiPrenotati()), evento.getPostiPrenotati()));
					} else {
						Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] L'evento è già passato e non puoi effettuare delle disdette." + ConsoleColors.RESET);
					}
				}
			} else {
				Menu.interazione(evento);
			}
			scanner.close();
		} catch (Exception e) {
			Menu.interazione(evento, ConsoleColors.RED + "[ERRORE] Abbiamo rilevato un errore ricontrolla i dati inseriti, assicurati di inserire un numero e non una stringa." + ConsoleColors.RESET);
		}
	}

}