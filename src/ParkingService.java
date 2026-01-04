
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;

public class ParkingService {

	private final TicketRepository ticketRepository;
	private final List<ParkingFeeStrategy> parkingFeeStrategies;
	private final int MAX_CAPACITY = 20;

	public ParkingService(TicketRepository ticketRepository, List<ParkingFeeStrategy> parkingFeeStrategies) {
		this.ticketRepository = ticketRepository;
		this.parkingFeeStrategies = parkingFeeStrategies;
	}
	
	public Ticket parkVehicle(Vehicle vehicle) {
		if (ticketRepository.count() >= MAX_CAPACITY) {
			throw new RuntimeException("The Parking Lot is Full!");
		}
		else {
			int ticketId = new Random().nextInt(10000);
			String spotId = "First Floor Spot " + ticketId;
			Ticket ticket = new Ticket(ticketId, vehicle, spotId);
			
			ticketRepository.save(ticket);
			System.out.println("Parked " + vehicle.getVehicleType() + " [" + vehicle.getLicensePlate() + "] at " + spotId);
			
			return ticket;
		}
	}
	
	public double processExit(Ticket ticket) {
		if (ticketRepository.findById(ticket.getTicketId()) == null) {
            throw new RuntimeException("Ticket not found or vehicle already exited.");
        }
		
		LocalDateTime exitTime = LocalDateTime.now();
		long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
		long hours = (long) Math.ceil(minutes / 60.0);
		
		VehicleType type = ticket.getVehicle().getVehicleType();
		ParkingFeeStrategy strategy = getStrategy(type);
		double fee = strategy.calculateFee(hours);
		
		ticketRepository.deleteById(ticket.getTicketId());
		
		System.out.println("Vehicle [" + ticket.getVehicle().getLicensePlate() + "] exiting. Hours:" + hours + " | Fee: $" + fee);
		return fee;
	}
	
	private ParkingFeeStrategy getStrategy(VehicleType type) {
		for (ParkingFeeStrategy strategy : parkingFeeStrategies) {
			if (strategy.getVehicleType() == type) {
				return strategy;
			}
		}
		throw new RuntimeException("pricing strategy not found for: " + type);
	}
	
}
