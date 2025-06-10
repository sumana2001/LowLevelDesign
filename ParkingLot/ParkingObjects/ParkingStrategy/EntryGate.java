package ParkingLot.ParkingObjects.ParkingStrategy;

import ParkingLot.ParkingObjects.ParkingTicket;
import ParkingLot.ParkingObjects.ParkingSpot.ParkingSpot;
import ParkingLot.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.Vehicle.Vehicle;

public class EntryGate {
    private ParkingSpotManager parkingSpotManager;
    private ParkingStrategy parkingStrategy;

    public EntryGate(ParkingSpotManager parkingSpotManager, ParkingStrategy parkingStrategy){
        this.parkingSpotManager=parkingSpotManager;
        this.parkingStrategy=parkingStrategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingSpot spot=parkingStrategy.findParkingSpot(parkingSpotManager, vehicle);
        if(spot==null){
            System.out.println("No spot available for "+vehicle.getVehicleNumber());
            return null;
        }
        spot.parkVehicle(vehicle);
        String ticketId="TICKET-"+System.currentTimeMillis();
        ParkingTicket ticket=new ParkingTicket(ticketId, vehicle, spot);
        System.out.println("Vehicle parked with ticket: "+ticketId);
        return ticket;
    }
}
