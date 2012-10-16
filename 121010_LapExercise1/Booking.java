
public class Booking {
	
	private int rowNumber;
	private int seatNumber;
	private int  ticketCount;
	//Um ein Booking eindeutig anzusprechen um es später zu löschen
	private int id;
    private static int numberOfBookings = 100;
	
	public Booking(int rowNumber, int seatNumber, int ticketCount) {
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.ticketCount = ticketCount;
		id = ++numberOfBookings;
	}
	
	public void printBooking() {
		System.out.println("Buchung mit der Nummer " + this.id + " in Reihe " + this.rowNumber + " mit folgenden Sitzen:");
		for (int i = seatNumber; i < seatNumber + ticketCount; i++) {
			System.out.println("Sitznummer: "+i);
		}
	}
	
	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}