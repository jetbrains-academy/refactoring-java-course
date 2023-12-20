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

public class FactoryMethodPatternTest extends BaseIjTestClass {
    private static String mainText;
    private static TestClass factoryClass;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path mainPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/Main.java");
        mainText = Files.readString(mainPath);

        factoryClass = new TestClass(
                "TransportationServiceFactory",
                "jetbrains.refactoring.course.patterns",
                Visibility.PUBLIC,
                ClassType.CLASS,
                emptyList(),
                List.of(
                        new TestMethod(
                                "getTransportation",
                                "Transport",
                                List.of(
                                        new TestVariable("transport", "String")
                                ),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );
    }

    @Test
    public void transportationServiceFactoryTest() {
        Assertions.assertDoesNotThrow(() -> {
            Class<?> clazz = factoryClass.checkBaseDefinition();
            factoryClass.checkDeclaredMethods(clazz);
        }, "Please, create a TransportationServiceFactory class with getTransportation method");
    }

    @Test
    public void mainClassTest() throws Exception {
        setUp();
        myFixture.configureByText("Main.java", mainText);
        Assertions.assertTrue(hasExpressionWithParent("new TransportationServiceFactory()", "main", true),
                "Please, create an instance of TransportationServiceFactory class in the main method");
    }
}
