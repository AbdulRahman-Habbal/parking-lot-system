
public class MotorcycleFeeStrategy implements ParkingFeeStrategy {

	@Override
	public double calculateFee(long hoursParked) {
		if (hoursParked <= 1) {
			return 0.0;
		}
		return (hoursParked - 1) * 1.0;
	}
	
	@Override
	public VehicleType getVehicleType() {
		return VehicleType.MOTORCYCLE;
	}
}
