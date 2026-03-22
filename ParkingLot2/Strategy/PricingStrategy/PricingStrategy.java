package ParkingLot2.Strategy.PricingStrategy;

import ParkingLot2.Ticket;

public interface PricingStrategy {
    double calculateAmount(Ticket ticket);
}
