import java.io.*;

//Ich fands übersichtlicher eine eigene Main zu haben, hier brauchen wir noch ein Menü, dass den User auffordert die Ticket Anzahl einzugeben oder zu löschen
public class Main {
	public static void main(String[] args) {
		Cinema hall = new Cinema();
		int bookingDecision = 0;

		while (bookingDecision != 4) {
			System.out.println();
			System.out
					.println("Was möchten Sie tun? \n 1 = Tickets buchen  \n 2 = Aktuelle Belegung anzeigen \n 3 = Buchung löschen \n 4 = Programm beenden");
			System.out.print("> ");
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				bookingDecision = Integer.parseInt(in.readLine());

				switch (bookingDecision) {
					case 1:
						System.out
								.println("Bitte geben Sie die Anzahl der Tickets ein, die Sie buchen möchten./n Der Preis pro Ticket ist: "+ Cinema.getTicketPrice()+" Euro");
						System.out.print("> ");
						try {
							BufferedReader anzahl = new BufferedReader(
									new InputStreamReader(System.in));
							int ticketCount = Integer.parseInt(anzahl.readLine());
							hall.book(ticketCount);
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
						}
						
						break;
					case 2:
						hall.printCinema();
						break;
					case 3:
						System.out
								.println("Bitte geben Sie die Buchungsnummer Ihrer Buchung ein.");
						System.out.print("> ");
						try {
							BufferedReader delete = new BufferedReader(
									new InputStreamReader(System.in));
							int bookingNumber = Integer.parseInt(delete.readLine());
							hall.deleteBooking(bookingNumber);
						} catch (IOException ex) {
							System.out.println(ex.getMessage());
						}
						break;
					case 4:
						System.out.println("Auf Wiedersehen!");
						break;
	
					default:
						System.out
								.println("Wir konnten Ihre Eingabe nicht erkennen.");
						break;
					}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

			/*
			 * hall.book(4); hall.book(5); hall.book(1); hall.book(1);
			 */

			// hall.deleteBooking(101);
		}
	}
}
