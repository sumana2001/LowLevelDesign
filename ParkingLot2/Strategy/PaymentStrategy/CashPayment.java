package ParkingLot2.Strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " via cash");
        return true;
    }
}
