package jetbrains.refactoring.course.patterns;

import java.time.LocalDate;

public class Main {
   public static void main(String[] args) {
      Order order1 = new Order(100.0, LocalDate.of(2023, 3, 1), "CreditCard");
      Order order2 = new Order(50.0, LocalDate.of(2023, 6, 1), "PayPal");
      Order order3 = new Order(200.0, LocalDate.of(2023, 9, 1), "Bitcoin");

      order1.processPayment();
      order2.processPayment();
      order3.processPayment();
   }
}