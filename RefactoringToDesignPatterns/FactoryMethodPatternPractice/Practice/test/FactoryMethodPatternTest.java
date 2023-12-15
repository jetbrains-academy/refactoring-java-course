import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FactoryMethodPatternTest extends BaseIjTestClass {

    private static String factoryText;
    private static String mainText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path factoryFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/TransportationServiceFactory.java");
        factoryText = Files.readString(factoryFilePath);
        Path mainPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/patterns/Main.java");
        mainText = Files.readString(mainPath);
    }

    @Test
    public void transportationServiceFactoryTest() throws Exception {
        setUp();
        myFixture.configureByText("TransportationServiceFactory.java", factoryText);
        Assertions.assertTrue(hasClass("TransportationServiceFactory"),
                "Please, create a TransportationServiceFactory class");
        Assertions.assertTrue(hasMethod("getTransportation"),
                "Please, define the getTransportation method in TransportationServiceFactory class");
    }

    @Test
    public void mainClassTest() throws Exception {
        setUp();
        myFixture.configureByText("Main.java", mainText);
        Assertions.assertTrue(hasExpressionWithParent("new TransportationServiceFactory()", "main", true),
                "Please, create an instance of TransportationServiceFactory class in the main method");
    }
}
