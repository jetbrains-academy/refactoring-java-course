package jetbrains.refactoring.course.patterns.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing PayPal payment: " + amount);
    }
}
