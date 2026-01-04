
public abstract class Vehicle {
	
	private VehicleType vehicleType;
	private String licensePlate;
	private String brand;
    private String color;
    
	
	public Vehicle(VehicleType vehicleType, String licensePlate, String brand, String color) {
		this.vehicleType = vehicleType;
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.color = color;
	}

	public Vehicle(String licensePlate, String brand, String color) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.color = color;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public String getBrand() {
			return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void displayCommonInfo() {
		System.out.println("Type: " + getVehicleType());
        System.out.println("License Plate: " + getLicensePlate());
        System.out.println("Brand: " + getBrand());
        System.out.println("Color: " + getColor());
	}
	
	public abstract void displayDetails();

}
