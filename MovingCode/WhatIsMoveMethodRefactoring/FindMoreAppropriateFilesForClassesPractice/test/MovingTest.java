import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MovingTest extends BaseIjTestClass {

    private static String carText;
    private static String driverText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path carPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/car/Car.java");
        carText = Files.readString(carPath);
        Path driverPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/driver/Driver.java");
        driverText = Files.readString(driverPath);
    }

    @Test
    public void testCarClassMoved() throws Exception {
        setUp();
        myFixture.configureByText("Car.java", carText);
        Assertions.assertTrue(hasClass("Car"),
                "Please, move the Car class to a separate file");
    }

    @Test
    public void testDriverClassMoved() throws Exception {
        setUp();
        myFixture.configureByText("Driver.java", driverText);
        Assertions.assertTrue(hasClass("Driver"),
                "Please, move the Driver class to a separate file");
    }
}
