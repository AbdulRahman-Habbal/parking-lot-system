
public class Motorcycle extends Vehicle {
	
	private int engineCC;

	public Motorcycle(String licensePlate, String brand, String color, int engineCC) {
		super(VehicleType.MOTORCYCLE, licensePlate, brand, color);
		this.engineCC = engineCC;
	}

	public int engineCC() {
		return engineCC;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("=== Motorcycle ===");
        displayCommonInfo();
        System.out.println("EngineCC: " + engineCC);
        System.out.println("--------------------");
	}

}
