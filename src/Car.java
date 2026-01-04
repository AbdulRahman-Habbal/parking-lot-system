
public class Car extends Vehicle {
	
	private boolean isElectric;

	public Car(String licensePlate, String brand, String color, boolean isElectric) {
		super(VehicleType.CAR, licensePlate, brand, color);
		this.isElectric = isElectric;
	}

	public boolean isElectric() {
		return isElectric;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("=== Car ===");
        displayCommonInfo();
        System.out.println("Electric: " + isElectric);
        System.out.println("--------------------");
	}

}
