package ParkingLot.ParkingObjects.ParkingSpot;

import ParkingLot.Vehicle.VehicleTypeEnum;

public class FourWheelerSpot extends ParkingSpot{
    public FourWheelerSpot(String id){
        super(id, 20, VehicleTypeEnum.FOUR_WHEELER);
    }
    
}
