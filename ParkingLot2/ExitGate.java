package ParkingLot2;

import ParkingLot2.Strategy.PaymentStrategy.PaymentStrategy;

public class ExitGate {
    ParkingLot parkingLot;
    PaymentStrategy strategy;

    public ExitGate(ParkingLot parkingLot, PaymentStrategy strategy) {
        this.parkingLot = parkingLot;
        this.strategy = strategy;
    }

    public double unpark(Ticket ticket) {
        return parkingLot.unparkVehicle(ticket, strategy);
    }
}
