package ParkingLot.ParkingObjects.ParkingStrategy;

import java.util.List;

import ParkingLot.ParkingObjects.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Vehicle.Vehicle;

public class NearExitGateStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle){
        List<ParkingSpot> spots=manager.getParkingSpots();
        for(int i=spots.size()-1;i>=0;i--){
            if(spots.get(i).isEmpty()){
                return spots.get(i);
            }
        }
        return null;
    }
}
