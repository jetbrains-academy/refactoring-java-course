package jetbrains.refactoring.course.patterns;

import java.time.LocalDate;

public class Order {

    private final double totalAmount;
    private final LocalDate date;

    public Order(double totalAmount, LocalDate date) {
        this.totalAmount = totalAmount;
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }
}
