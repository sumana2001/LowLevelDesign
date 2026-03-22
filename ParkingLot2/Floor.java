package ParkingLot2;

import java.util.List;

public class Floor {
    int level;
    List<ParkingSpot> spots;

    public Floor(int level, List<ParkingSpot> spots) {
        this.level = level;
        this.spots = spots;
    }

    public List<ParkingSpot> getAvailableSpots() {
        return spots.stream().filter(s -> !s.isOccupied).toList();
    }
}
