package ParkingLot2;

public class EntryGate {
    ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }
}
