
public class Truck extends Vehicle {

	private double height;

	public Truck(String licensePlate, String brand, String color, double height) {
		super(VehicleType.TRUCK, licensePlate, brand, color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("=== Truck ===");
        displayCommonInfo();
        System.out.println("Truck's Height: " + height);
        System.out.println("--------------------");
	}
}
