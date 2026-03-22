package ParkingLot2.Strategy.ParkingStrategy;

import ParkingLot2.*;
import java.util.*;

public interface ParkingStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<ParkingSpot> spots);
}
