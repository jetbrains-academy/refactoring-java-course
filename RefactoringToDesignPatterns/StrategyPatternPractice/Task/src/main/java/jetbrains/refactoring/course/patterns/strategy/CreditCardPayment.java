package jetbrains.refactoring.course.patterns.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing credit card payment: " + amount);
    }
}
