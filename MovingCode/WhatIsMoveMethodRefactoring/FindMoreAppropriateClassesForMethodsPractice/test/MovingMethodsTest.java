import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MovingMethodsTest extends BaseIjTestClass {

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
    public void testStartAndStopMethodMovedToCarClass() throws Exception {
        setUp();
        myFixture.configureByText("Car.java", carText);
        Assertions.assertTrue(hasMethod("start"),
                "Please, move the \"start\" method");
        Assertions.assertTrue(hasMethod("stop"),
                "Please, move the \"stop\" method");
    }

    @Test
    public void testStartAndStopMethodRemovedFromDriverClass() throws Exception {
        setUp();
        myFixture.configureByText("Driver.java", driverText);
        Assertions.assertFalse(hasMethod("start"),
                "Please, remove the \"start\" method from the Driver class");
        Assertions.assertFalse(hasMethod("stop"),
                "Please, remove the \"stop\" method from the Driver class");
    }
}
