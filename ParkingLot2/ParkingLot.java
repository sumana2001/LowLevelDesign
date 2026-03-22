package ParkingLot2;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import ParkingLot2.Strategy.ParkingStrategy.*;
import ParkingLot2.Strategy.PaymentStrategy.PaymentStrategy;
import ParkingLot2.Strategy.PricingStrategy.*;

public class ParkingLot {
    List<Floor> floors;
    ParkingStrategy strategy;
    PricingStrategy pricingStrategy;
    Map<ParkingType, Queue<ParkingSpot>> availableSpotsMap;

    public ParkingLot(List<Floor> floors, ParkingStrategy strategy, PricingStrategy pricingStrategy) {
        this.floors = floors;
        this.strategy = strategy;
        this.pricingStrategy = pricingStrategy;
        this.availableSpotsMap = new ConcurrentHashMap<>();
        initializeSpots();
    }

    private void initializeSpots() {
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.spots) {
                availableSpotsMap.computeIfAbsent(spot.type, k -> new ConcurrentLinkedQueue<>()).offer(spot);
            }
        }
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        ParkingType type = ParkingType.valueOf(vehicle.type.name());
        Queue<ParkingSpot> queue = availableSpotsMap.get(type);
        if (queue == null || queue.isEmpty()) {
            throw new RuntimeException("No available parking spots found");
        }
        ParkingSpot spot = queue.poll();
        if (spot == null) {
            throw new RuntimeException("Race condition occured");
        }
        spot.assignVehicle(vehicle);
        return new Ticket(vehicle, spot);
    }

    public synchronized double unparkVehicle(Ticket ticket, PaymentStrategy paymentStrategy) {
        double amount = pricingStrategy.calculateAmount(ticket);
        boolean success = paymentStrategy.pay(amount);
        if (success) {
            ParkingSpot spot = ticket.getSpot();
            if (spot == null) {
                throw new RuntimeException("Invalid ticket, no parking spot linked to ticket");
            }
            spot.unAssignVehicle();
            availableSpotsMap.get(spot.type).offer(spot);
            ticket.closeTicket();
        } else {
            throw new RuntimeException("Payment failed");
        }
        return amount;
    }
}
