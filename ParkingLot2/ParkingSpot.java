package ParkingLot2;

public class ParkingSpot {
    String id;
    ParkingType type;
    boolean isOccupied;
    Vehicle vehicle;

    public ParkingSpot(String id, ParkingType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle v) {
        return this.type.name().equals(v.type.name());
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.isOccupied = true;
    }

    public void unAssignVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
