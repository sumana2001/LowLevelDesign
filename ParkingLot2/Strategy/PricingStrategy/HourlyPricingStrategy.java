package ParkingLot2.Strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

import ParkingLot2.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final double RATE_PER_HOUR = 20.0;

    @Override
    public double calculateAmount(Ticket ticket) {
        long hours = Duration.between(ticket.entryTime, LocalDateTime.now()).toHours() + 1;
        return hours * RATE_PER_HOUR;
    }
}
