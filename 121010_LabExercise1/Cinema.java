import java.util.ArrayList;


public class Cinema {

	//Hier habe ich einfach einen Boolean für besetzt oder nicht anstatt 0 und 1 genommen
	private boolean[][] seats = new boolean[5][10];
	//Die Booking Objekte werden in einer Arraylist gespeichert
	private ArrayList<Booking> bookings = new ArrayList<Booking>();
	// Unser Ticketprice für ein ticket
	private static int ticketPrice = 5;
	
	public Cinema() {
		for (int rowNumber = 0; rowNumber < seats.length; rowNumber++) {
			for (int seatNumber = 0; seatNumber < seats[0].length; seatNumber++) {
				seats[rowNumber][seatNumber] = false;
			}
		}
		/*seats[0][0] = true;
		seats[0][4] = true;
		seats[0][2] = true;
		seats[0][9] = true;
		seats[0][0] = true;
		*/
		
		//System.out.println("### Kino - Ursprungszustand ###");
		//this.printCinema();
	}
	
	//Funktion muss noch fertig geschrieben werden, sodass die Sitze wieder frei werden
	public boolean deleteBooking(int bookingId) {
		Booking foundBooking = null;
		
		for (Booking b : bookings) {
			if (b.getId() == bookingId) {
				foundBooking = b;
			}
		}

		if (foundBooking != null) {
			bookings.remove(foundBooking);
				for (int remarker = foundBooking.getSeatNumber(); remarker!= foundBooking.getTicketCount();remarker++){
					seats[foundBooking.getRowNumber()][remarker] = false; 
				}
				System.out.println("Die Buchung wurde erfolgreich gelöscht.");
				return true;
		}
		System.out.println("Diese Buchungsnummer ist nicht vergeben!");
		return false;
	}
	
	//Hab ich umgeschrieben, damit geguckt werden kann ob die gewünschte Anzahl von Sitzen frei ist
	public boolean book(int ticketCount) {
		for (int rowNumber = 0; rowNumber < seats.length; rowNumber++) {
			int freeSeats = 0;
			for (int seatNumber = 0; seatNumber < seats[0].length; seatNumber++) {
				if (seats[rowNumber][seatNumber] == false) {
					freeSeats++;
					if (freeSeats == ticketCount) {
						for (int marker = seatNumber; marker > seatNumber - ticketCount; marker--) {
							seats[rowNumber][marker] = true;
						}
						Booking booking = new Booking(rowNumber, seatNumber  + 1 - ticketCount, ticketCount);
						bookings.add(booking);
						//System.out.println("### Kino - Nach Buchung ####");
						//this.printCinema();
						booking.printBooking();
						System.out.println("Für die "+ ticketCount + " Tickets wird ein Preis von: " + ticketCount * ticketPrice + " Euro fällig."  );
						return true;
					}
				} else {
					freeSeats = 0;
				}
			}
			
		}
		System.out.println("Es gibt nicht so viele zusammenhängende Plätze.");
		return false;
	}

	public void printCinema() {
		for (int rowNumber = 0; rowNumber < seats.length; rowNumber++) {
			for (int seatNumber = 0; seatNumber < seats[0].length; seatNumber++) {
				if (seats[rowNumber][seatNumber] == true) {
					System.out.print("X");					
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}
	
	public static int getTicketPrice(){
		return ticketPrice;
	}
}