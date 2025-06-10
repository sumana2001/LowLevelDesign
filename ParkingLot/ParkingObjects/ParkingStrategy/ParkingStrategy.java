package ParkingLot.ParkingObjects.ParkingStrategy;

import ParkingLot.ParkingObjects.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Vehicle.Vehicle;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle);
}
