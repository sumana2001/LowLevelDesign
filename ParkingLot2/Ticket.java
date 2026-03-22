package ParkingLot2;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    String id;
    Vehicle vehicle;
    ParkingSpot spot;
    public LocalDateTime entryTime;
    LocalDateTime exitTime;
    TicketStatus status;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public ParkingSpot getSpot() {
        return this.spot;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.status = TicketStatus.EXITED;
    }
}
