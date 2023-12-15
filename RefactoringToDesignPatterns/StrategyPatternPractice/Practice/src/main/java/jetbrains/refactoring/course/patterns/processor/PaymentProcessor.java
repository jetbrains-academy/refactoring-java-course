package jetbrains.refactoring.course.patterns.processor;

import jetbrains.refactoring.course.patterns.strategy.PaymentStrategy;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrderPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
