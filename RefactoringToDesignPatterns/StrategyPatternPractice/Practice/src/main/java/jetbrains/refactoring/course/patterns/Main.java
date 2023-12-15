package jetbrains.refactoring.course.patterns;

import jetbrains.refactoring.course.patterns.processor.PaymentProcessor;
import jetbrains.refactoring.course.patterns.strategy.BitcoinPayment;
import jetbrains.refactoring.course.patterns.strategy.CreditCardPayment;
import jetbrains.refactoring.course.patterns.strategy.PayPalPayment;

import java.time.LocalDate;

public class Main {
   public static void main(String[] args) {
      Order order1 = new Order(100.0, LocalDate.of(2023, 3, 1));
      Order order2 = new Order(50.0, LocalDate.of(2023, 6, 1));
      Order order3 = new Order(200.0, LocalDate.of(2023, 9, 1));

      PaymentProcessor creditCardPayment = new PaymentProcessor(new CreditCardPayment());
      PaymentProcessor paypalPayment = new PaymentProcessor(new PayPalPayment());
      PaymentProcessor bitcoinPayment = new PaymentProcessor(new BitcoinPayment());

      creditCardPayment.processOrderPayment(order1.getTotalAmount());
      paypalPayment.processOrderPayment(order2.getTotalAmount());
      bitcoinPayment.processOrderPayment(order3.getTotalAmount());
   }
}