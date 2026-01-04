
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ParkingLotApplication {

	public static void main(String[] args) {
		System.out.println("========== PARKING LOT SYSTEM STARTING ==========");

        // ---------------------------------------------------------
        // 1. BOOTSTRAP (Manual Dependency Injection)
        // ---------------------------------------------------------
        // We create the "Database"
        TicketRepository repository = new InMemoryTicketRepository();

        // We load the "Rules" (Strategies)
        List<ParkingFeeStrategy> strategies = Arrays.asList(
            new CarFeeStrategy(),
            new TruckFeeStrategy(),
            new MotorcycleFeeStrategy()
        );

        // We start the "Engine" (Service)
        ParkingService service = new ParkingService(repository, strategies);
        System.out.println(">> System Initialized. Capacity: 20 Spots.\n");

        // ---------------------------------------------------------
        // 2. CREATE VEHICLES
        // ---------------------------------------------------------
        Vehicle myCar = new Car("ABC-123", "Toyota", "Silver", false);
        Vehicle deliveryTruck = new Truck("BIG-999", "Volvo", "Red", 3.5);
        Vehicle moto = new Motorcycle("MOTO-55", "Harley", "Black", 1000);

        // ---------------------------------------------------------
        // 3. SIMULATE PARKING (Entry)
        // ---------------------------------------------------------
        System.out.println("--- VEHICLES ENTERING ---");
        Ticket ticket1 = service.parkVehicle(myCar);
        Ticket ticket2 = service.parkVehicle(deliveryTruck);
        Ticket ticket3 = service.parkVehicle(moto);
        
        System.out.println(">> Current Vehicles in Lot: " + repository.count());

        // ---------------------------------------------------------
        // 4. SIMULATE TIME PASSING (The Test)
        // ---------------------------------------------------------
        System.out.println("\n--- TIME WARP: 4 HOURS PASS ---");
        
        // We manually change the entry time to 4 hours ago
        // Math Expectation: 
        // Car: 1st hr free, 3 hrs * $2 = $6.00
        // Truck: 1st hr free, 3 hrs * $5 = $15.00
        
        ticket1.setEntryTime(LocalDateTime.now().minusHours(4));
        ticket2.setEntryTime(LocalDateTime.now().minusHours(4));
        
        // ---------------------------------------------------------
        // 5. SIMULATE EXIT (Transaction)
        // ---------------------------------------------------------
        System.out.println("\n--- VEHICLES EXITING ---");
        
        service.processExit(ticket1); // Should be $6.0
        service.processExit(ticket2); // Should be $15.0

        System.out.println("\n>> Remaining Vehicles: " + repository.count());
        System.out.println("========== SYSTEM SHUTDOWN ==========");
    }
}