### Task

- Create a base interface `PaymentStrategy` for payment strategy classes with the `void processPayment(Double amount);`
  method.
- Implement a separate class for each payment method: `CreditCardPayment`, `PayPalPayment`, and `BitcoinPayment`.
  Each of these classes should implement the base `PaymentStrategy` interface and override the `processPayment`
  method.
- Create a `PaymentProcessor` class that encapsulates payment behavior.
  This class should take as a constructor parameter `PaymentStrategy paymentStrategy`
  and should contain the `processOrderPayment` method, which invokes the `processPayment` method from `paymentStrategy`.
- Transform the `Order` class into a class that only stores the order's total amount and date data. Implement getters for these fields.
- Within the `Main::main` method, instantiate an `Order` object for each order and a `PaymentProcessor` for each payment type.
  Make sure to pass the corresponding payment strategy when creating the `PaymentProcessor` object.

By using the **Strategy** design pattern, payment processing logic is separated from the `Order` class,
making it more flexible and maintainable.
Adding new payment methods or modifying existing ones becomes easier and doesn't affect the `Order` class.
The client code also becomes cleaner, as it focuses on creating instances of `PaymentProcessor` with the desired payment
strategies.

### Hints

<div class="hint" title="Where to start?">

The file where you should write the code is already open.
Please create an interface named `PaymentStrategy` and add the `void processPayment(Double amount)` method.
</div>

<div class="hint" title="How should PaymentProcessor class look?">

Here's the PaymentProcessor code:

```java
public class PaymentProcessor {

  private PaymentStrategy paymentStrategy;

  public PaymentProcessor(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public void processOrderPayment(double amount) {
    paymentStrategy.processPayment(amount);
  }
}
```

</div>

<div class="hint" title="How should PaymentStrategy subclasses look?">

For example, for a credit card payment type, the code would be:

```java
public class CreditCardPayment implements PaymentStrategy {
  @Override
  public void processPayment(Double amount) {
    System.out.println("Processing credit card payment: " + amount);
  }
}
```

</div>

<div class="hint" title="How to fix main method?">

In the main method, **for each order**, you should instantiate an `Order` object, providing it with the corresponding total amount and date.
Then, you need to instantiate a `PaymentProcessor` object, supplying it with the appropriate payment strategy as an argument.
Finally, you should invoke the `processOrderPayment` method.
For example, the code for processing a payment with a credit card would be:

```java
public class Main {
  public static void main(String[] args) {
    Order order1 = new Order(100.0, LocalDate.of(2023, 3, 1));
    PaymentProcessor creditCardPayment = new PaymentProcessor(new CreditCardPayment());
    creditCardPayment.processOrderPayment(order1.getTotalAmount());
  }
}
```

</div>
