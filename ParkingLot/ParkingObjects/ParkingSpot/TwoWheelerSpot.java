package ParkingLot.ParkingObjects.ParkingSpot;

import ParkingLot.Vehicle.VehicleTypeEnum;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String id){
        super(id, 10, VehicleTypeEnum.TWO_WHEELER);
    }
}
