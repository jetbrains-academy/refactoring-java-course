package jetbrains.refactoring.course.patterns.strategy;

public class BitcoinPayment implements PaymentStrategy {
    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing Bitcoin payment: " + amount);
    }
}
