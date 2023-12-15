import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StrategyPatternTest extends BaseIjTestClass {

    private static String mainText;
    private static String orderText;
    private static String paymentProcessorText;
    private static String bitcoinText;
    private static String creditText;
    private static String payPalText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path mainPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/Main.java");
        mainText = Files.readString(mainPath);
        Path orderPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/Order.java");
        orderText = Files.readString(orderPath);
        Path paymentProcessorPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/processor/PaymentProcessor.java");
        paymentProcessorText = Files.readString(paymentProcessorPath);
        Path bitcoinPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/strategy/BitcoinPayment.java");
        bitcoinText = Files.readString(bitcoinPath);
        Path creditPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/strategy/CreditCardPayment.java");
        creditText = Files.readString(creditPath);
        Path payPalPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/strategy/PayPalPayment.java");
        payPalText = Files.readString(payPalPath);
    }

    @Test
    public void paymentTest() throws Exception {
        setUp();
        myFixture.configureByText("PaymentProcessor.java", paymentProcessorText);
        Assertions.assertTrue(hasClass("PaymentProcessor"),
                "Please, create a PaymentProcessor class");
        Assertions.assertTrue(hasField("paymentStrategy"),
                "Please, define a constructor parameter paymentStrategy in PaymentProcessor class");
        Assertions.assertTrue(hasMethod("processOrderPayment"),
                "Please, define the processOrderPayment method in PaymentProcessor class");
        Assertions.assertTrue(hasExpressionWithParent("paymentStrategy.processPayment", "processOrderPayment", true),
                "Please, invoke the processPayment method from paymentStrategy in processOrderPayment method.");
        myFixture.configureByText("BitcoinPayment.java", bitcoinText);
        Assertions.assertTrue(hasClass("BitcoinPayment"),
                "Please, create a BitcoinPayment class");
        Assertions.assertTrue(hasMethod("processPayment"),
                "Please, override the processPayment method in the BitcoinPayment class");
        myFixture.configureByText("CreditCardPayment.java", creditText);
        Assertions.assertTrue(hasClass("CreditCardPayment"),
                "Please, create a CreditCardPayment class");
        Assertions.assertTrue(hasMethod("processPayment"),
                "Please, override the processPayment method in the CreditCardPayment class");
        myFixture.configureByText("PayPalPayment.java", payPalText);
        Assertions.assertTrue(hasClass("PayPalPayment"),
                "Please, create a PayPalPayment class");
        Assertions.assertTrue(hasMethod("processPayment"),
                "Please, override the processPayment method in the PayPalPayment class");
        myFixture.configureByText("Order.java", orderText);
        Assertions.assertFalse(hasMethod("processPayment"),
                "Please, remove the processPayment method from the Oder class");
        Assertions.assertFalse(hasField("paymentMethod"),
                "Please, remove the paymentMethod field from the Oder class");
        Assertions.assertTrue(hasMethod("getTotalAmount"),
                "Please, implement getter for the totalAmount field in the Order class");
    }

    @Test
    public void mainClassTest() throws Exception {
        setUp();
        myFixture.configureByText("Main.java", mainText);
        String expression = "new CreditCardPayment()";
        String parent = "main";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
            "Please, create an instance of PaymentProcessor for CreditCardPayment in the main method");
        expression = "new PayPalPayment()";
        parent = "main";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
            "Please, create an instance of PaymentProcessor for PayPalPayment in the main method");
        expression = "new BitcoinPayment()";
        parent = "main";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
            "Please, create an instance of PaymentProcessor for BitcoinPayment in the main method");
        String method = "creditCardPayment.processOrderPayment(order1.getTotalAmount())";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of("main"),
                "Please, invoke the " + method + " method of Credit Card Payment and pass in the totalAmount from the first order within the main method");
        method = "paypalPayment.processOrderPayment(order2.getTotalAmount())";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of("main"),
                "Please, invoke the " + method + " method of PayPal Payment and pass in the totalAmount from the second order within the main method");
        method = "bitcoinPayment.processOrderPayment(order3.getTotalAmount())";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of("main"),
                "Please, invoke the " + method + " method of Bitcoin Payment and pass in the totalAmount from the third order within the main method");
    }
}
