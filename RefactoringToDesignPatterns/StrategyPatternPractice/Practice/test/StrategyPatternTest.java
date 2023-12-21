import org.jetbrains.academy.test.system.core.models.Visibility;
import org.jetbrains.academy.test.system.core.models.classes.ClassType;
import org.jetbrains.academy.test.system.core.models.classes.TestClass;
import org.jetbrains.academy.test.system.core.models.method.TestMethod;
import org.jetbrains.academy.test.system.core.models.variable.TestVariable;
import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Collections.emptyList;

public class StrategyPatternTest extends BaseIjTestClass {

    private static String mainText;
    private static String paymentProcessorText;
    private static TestClass orderClass;
    private static TestClass paymentProcessorClass;
    private static TestClass paymentStrategyClass;
    private static TestClass bitcoinClass;
    private static TestClass creditClass;
    private static TestClass payPalClass;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path mainPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/Main.java");
        mainText = Files.readString(mainPath);
        Path paymentProcessorPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/processor/PaymentProcessor.java");
        paymentProcessorText = Files.readString(paymentProcessorPath);

        paymentProcessorClass = new TestClass(
                "PaymentProcessor",
                "jetbrains.refactoring.course.patterns.processor",
                Visibility.PUBLIC,
                ClassType.CLASS,
                List.of(
                        new TestVariable(
                                "paymentStrategy",
                                "PaymentStrategy",
                                null,
                                Visibility.PRIVATE,
                                false,
                                true,
                                false
                        )
                ),
                List.of(
                        new TestMethod(
                                "processOrderPayment",
                                "void",
                                List.of(new TestVariable("amount", "double")),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );

        orderClass = new TestClass(
                "Order",
                "jetbrains.refactoring.course.patterns",
                Visibility.PUBLIC,
                ClassType.CLASS,
                List.of(
                        new TestVariable(
                                "totalAmount",
                                "double",
                                null,
                                Visibility.PRIVATE,
                                true,
                                true,
                                false
                        ),
                        new TestVariable(
                                "date",
                                "LocalDate",
                                null,
                                Visibility.PRIVATE,
                                true,
                                true,
                                false
                        )
                ),
                List.of(
                        new TestMethod(
                                "getTotalAmount",
                                "double",
                                emptyList(),
                                Visibility.PUBLIC
                        ),
                        new TestMethod(
                                "getDate",
                                "LocalDate",
                                emptyList(),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );

        paymentStrategyClass = new TestClass(
                "PaymentStrategy",
                "jetbrains.refactoring.course.patterns.strategy",
                Visibility.PUBLIC,
                ClassType.INTERFACE,
                emptyList(),
                List.of(
                        new TestMethod(
                                "processPayment",
                                "void",
                                List.of(new TestVariable("amount", "double")),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );

        bitcoinClass = new TestClass(
                "BitcoinPayment",
                "jetbrains.refactoring.course.patterns.strategy",
                Visibility.PUBLIC,
                ClassType.CLASS,
                emptyList(),
                List.of(
                        new TestMethod(
                                "processPayment",
                                "void",
                                List.of(new TestVariable("amount", "double")),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                List.of(paymentStrategyClass)
        );

        creditClass = new TestClass(
                "CreditCardPayment",
                "jetbrains.refactoring.course.patterns.strategy",
                Visibility.PUBLIC,
                ClassType.CLASS,
                emptyList(),
                List.of(
                        new TestMethod(
                                "processPayment",
                                "void",
                                List.of(new TestVariable("amount", "double")),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                List.of(paymentStrategyClass)
        );

        payPalClass = new TestClass(
                "PayPalPayment",
                "jetbrains.refactoring.course.patterns.strategy",
                Visibility.PUBLIC,
                ClassType.CLASS,
                emptyList(),
                List.of(
                        new TestMethod(
                                "processPayment",
                                "void",
                                List.of(new TestVariable("amount", "double")),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                List.of(paymentStrategyClass)
        );
    }

    @Test
    public void paymentProcessorClassTest() throws Exception {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = paymentProcessorClass.checkBaseDefinition();
            paymentProcessorClass.checkDeclaredMethods(clazz);
            paymentProcessorClass.checkFieldsDefinition(clazz, true);
        }, "Please, create a PaymentProcessor class with a constructor parameter paymentStrategy and processOrderPayment method");
    }

    @Test
    public void bitcoinPaymentClassTest() {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = bitcoinClass.checkBaseDefinition();
            bitcoinClass.checkDeclaredMethods(clazz);
        }, "Please, create a BitcoinPayment class with processPayment method");
    }

    @Test
    public void creditCardPaymentClassTest() {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = creditClass.checkBaseDefinition();
            creditClass.checkDeclaredMethods(clazz);
        }, "Please, create a CreditCardPayment class with processPayment method");
    }

    @Test
    public void payPalPaymentClassTest() {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = payPalClass.checkBaseDefinition();
            payPalClass.checkDeclaredMethods(clazz);
        }, "Please, create a PayPalPayment class with processPayment method");
    }

    @Test
    public void orderClassTest() {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = orderClass.checkBaseDefinition();
            orderClass.checkFieldsDefinition(clazz, true);
        }, "Please, transform the Order class into a class that only stores two fields: totalAmount: Double and date: LocalDate. Implement getters for these fields.");
    }

    @Test
    public void testCreatedInstancesInMainMethod() throws Exception {
        setUp();
        myFixture.configureByText("Main.java", mainText);
        String expression = "new CreditCardPayment()";
        String parent = "main";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
                "Please, create an instance of PaymentProcessor for CreditCardPayment in the main method");
        expression = "new PayPalPayment()";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
                "Please, create an instance of PaymentProcessor for PayPalPayment in the main method");
        expression = "new BitcoinPayment()";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
                "Please, create an instance of PaymentProcessor for BitcoinPayment in the main method");
    }

    @Test
    public void testInvokedMethodsOfPaymentClassesInMainMethod() throws Exception {
        setUp();
        myFixture.configureByText("Main.java", mainText);
        String method = "creditCardPayment.processOrderPayment(order1.getTotalAmount())";
        String mainMethod = "main";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of(mainMethod),
                "Please, invoke the " + method + " method of Credit Card Payment and pass in the totalAmount from the first order within the main method");
        method = "paypalPayment.processOrderPayment(order2.getTotalAmount())";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of(mainMethod),
                "Please, invoke the " + method + " method of PayPal Payment and pass in the totalAmount from the second order within the main method");
        method = "bitcoinPayment.processOrderPayment(order3.getTotalAmount())";
        Assertions.assertEquals(
                findMethodUsages(method),
                List.of(mainMethod),
                "Please, invoke the " + method + " method of Bitcoin Payment and pass in the totalAmount from the third order within the main method");
    }
}
