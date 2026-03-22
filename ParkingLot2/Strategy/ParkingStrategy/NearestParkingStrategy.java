package ParkingLot2.Strategy.ParkingStrategy;

import java.util.List;

import ParkingLot2.*;

public class NearestParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots) {
        for (ParkingSpot spot : spots) {
            if (spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }
}
