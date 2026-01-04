
public interface ParkingFeeStrategy {

	double calculateFee(long hoursParked);
	
	VehicleType getVehicleType();
}
