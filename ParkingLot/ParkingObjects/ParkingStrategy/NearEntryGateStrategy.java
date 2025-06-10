package ParkingLot.ParkingObjects.ParkingStrategy;

import java.util.List;

import ParkingLot.ParkingObjects.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Vehicle.Vehicle;

public class NearEntryGateStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle){
        List<ParkingSpot> spots=manager.getParkingSpots();
        for(ParkingSpot spot: spots){
            if(spot.isEmpty()){
                return spot;
            }
        }
        return null;
    }
}
