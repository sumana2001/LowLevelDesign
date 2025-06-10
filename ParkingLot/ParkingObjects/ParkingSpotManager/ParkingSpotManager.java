package ParkingLot.ParkingObjects.ParkingSpotManager;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.ParkingObjects.ParkingSpot.ParkingSpot;

public class ParkingSpotManager<T extends ParkingSpot> {
    protected List<T> parkingSpots;

    public ParkingSpotManager(){
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(T parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(T parkingSpot){
        parkingSpots.remove(parkingSpot);
    }

    public List<T> getParkingSpots(){
        return parkingSpots;
    }
}
