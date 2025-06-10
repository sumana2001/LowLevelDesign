package ParkingLot.ParkingObjects;

import java.util.HashMap;
import java.util.Map;

import ParkingLot.ParkingObjects.ParkingSpot.FourWheelerSpot;
import ParkingLot.ParkingObjects.ParkingSpot.TwoWheelerSpot;
import ParkingLot.ParkingObjects.ParkingSpotManager.ParkingSpotManager;
import ParkingLot.ParkingObjects.ParkingStrategy.EntryGate;
import ParkingLot.ParkingObjects.ParkingStrategy.ExitGate;
import ParkingLot.ParkingObjects.ParkingStrategy.NearEntryGateStrategy;
import ParkingLot.ParkingObjects.ParkingStrategy.ParkingStrategy;
import ParkingLot.Vehicle.Vehicle;

public class ParkingLot {
    private ParkingSpotManager parkingSpotManager;
    private EntryGate entryGate;
    private ExitGate exitGate;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot(){
        this.parkingSpotManager=new ParkingSpotManager();
        this.activeTickets=new HashMap<>();

        for(int i=1;i<=5;i++){
            parkingSpotManager.addParkingSpot(new TwoWheelerSpot("TW-"+i));
            parkingSpotManager.addParkingSpot(new FourWheelerSpot("FW-"+i));
        }
        ParkingStrategy strategy=new NearEntryGateStrategy();
        this.entryGate=new EntryGate(parkingSpotManager,strategy);
        this.exitGate=new ExitGate(activeTickets);
    }

    public ParkingTicket enterVehicle(Vehicle vehicle){
        ParkingTicket ticket=entryGate.parkVehicle(vehicle);
        if(ticket!=null){
            activeTickets.put(ticket.getTicketId(), ticket);
        }
        return ticket;
    }

    public void exitVehicle(String ticketId){
        exitGate.exitVehicle(ticketId);
    }
}
