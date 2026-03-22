package ParkingLot2;

import java.util.Arrays;
import java.util.List;

import ParkingLot2.Strategy.ParkingStrategy.NearestParkingStrategy;
import ParkingLot2.Strategy.ParkingStrategy.ParkingStrategy;
import ParkingLot2.Strategy.PaymentStrategy.CashPayment;
import ParkingLot2.Strategy.PaymentStrategy.PaymentStrategy;
import ParkingLot2.Strategy.PricingStrategy.HourlyPricingStrategy;
import ParkingLot2.Strategy.PricingStrategy.PricingStrategy;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> floor1Spots = Arrays.asList(
                new ParkingSpot("F1-S1", ParkingType.CAR),
                new ParkingSpot("F1-S2", ParkingType.BIKE),
                new ParkingSpot("F1-S3", ParkingType.CAR));
        List<ParkingSpot> floor2Spots = Arrays.asList(
                new ParkingSpot("F2-S1", ParkingType.TRUCK),
                new ParkingSpot("F2-S2", ParkingType.CAR));

        Floor f1 = new Floor(1, floor1Spots);
        Floor f2 = new Floor(2, floor2Spots);

        List<Floor> floors = Arrays.asList(f1, f2);

        ParkingStrategy parkingStrategy = new NearestParkingStrategy();
        PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        PaymentStrategy paymentStrategy = new CashPayment();

        ParkingLot parkingLot = new ParkingLot(floors, parkingStrategy, pricingStrategy);

        EntryGate entryGate = new EntryGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot, paymentStrategy);

        Vehicle car1 = new Vehicle("CAR123", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("BIKE123", VehicleType.BIKE);

        Ticket t1 = entryGate.park(car1);
        System.out.println("Parked car at spot " + t1.spot.id);

        Ticket t2 = entryGate.park(bike1);
        System.out.println("Parked Bike at spot: " + t2.spot.id);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        double amount1 = exitGate.unpark(t1);
        System.out.println("Amount paid: " + amount1);

        double amount2 = exitGate.unpark(t2);
        System.out.println("Amount paid: " + amount2);
    }
}
