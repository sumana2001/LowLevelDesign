package ParkingLot.ParkingObjects.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.Map;

import ParkingLot.ParkingObjects.ParkingTicket;

public class ExitGate {
    private Map<String,ParkingTicket> activeTickets;

    public ExitGate(Map<String,ParkingTicket> activeTickets){
        this.activeTickets=activeTickets;
    }
    
    public void exitVehicle(String ticketId){
        if(!activeTickets.containsKey(ticketId)){
            System.out.println("Invalid Ticket ID");
            return;
        }
        ParkingTicket ticket=activeTickets.get(ticketId);
        int fare=ticket.calculateFare(LocalDateTime.now());

        ticket.getParkingSpot().removeVehicle();
        activeTickets.remove(ticketId);
        System.out.println("Vehicle exited. Total fare: "+fare);
    }
}
