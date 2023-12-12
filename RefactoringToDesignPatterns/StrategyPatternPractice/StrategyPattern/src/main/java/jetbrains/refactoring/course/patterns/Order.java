package jetbrains.refactoring.course.patterns;

import java.time.LocalDate;

public class Order {

    private final double totalAmount;
    private final LocalDate date;
    private final String paymentMethod;

    public Order(double totalAmount, LocalDate date, String paymentMethod) {
        this.totalAmount = totalAmount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        switch (paymentMethod) {
            case "CreditCard":
                System.out.println("Processing credit card payment: " + totalAmount);
                break;
            case "PayPal":
                System.out.println("Processing PayPal payment: " + totalAmount);
                break;
            case "Bitcoin":
                System.out.println("Processing Bitcoin payment: " + totalAmount);
                break;
            default:
                System.out.println("Invalid payment method");
                break;
        }
    }
}
