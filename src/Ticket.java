
import java.time.LocalDateTime;

public class Ticket {

	private int ticketId;
	private Vehicle vehicle;
    private String spotId;
    private LocalDateTime entryTime;
    
    public Ticket(int ticketId, Vehicle vehicle, String spotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    //Constructor for testing
    public Ticket(int ticketId, Vehicle vehicle, String spotId, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }
    
	public int getTicketId() {
		return ticketId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	
	public String getSpotId() {
		return spotId;
	}
	
	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	//Method for testing
	public void setEntryTime(java.time.LocalDateTime time) {
	    this.entryTime = time;
	}
	
}
