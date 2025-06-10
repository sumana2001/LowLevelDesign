package ParkingLot;

import ParkingLot.ParkingObjects.ParkingLot;
import ParkingLot.ParkingObjects.ParkingTicket;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleTypeEnum;

public class Main {
    public static void main(String[] args){
        ParkingLot parkingLot=new ParkingLot();
        Vehicle bike=new Vehicle("BIKE-123", VehicleTypeEnum.TWO_WHEELER);
        Vehicle car=new Vehicle("CAR-456", VehicleTypeEnum.FOUR_WHEELER);
        ParkingTicket bikeTicket=parkingLot.enterVehicle(bike);
        ParkingTicket carTicket=parkingLot.enterVehicle(car);
        if(bikeTicket!=null) parkingLot.exitVehicle(bikeTicket.getTicketId());
        if(carTicket!=null) parkingLot.exitVehicle(carTicket.getTicketId());
    }
}
