package org.milestone.events.elijah;



public class Menu {

	static void spaceConsole() {
		for (int i = 0; i < 100; i++) {
			System.err.println();
		}
	}

	static void displayHeaderConsole() {
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