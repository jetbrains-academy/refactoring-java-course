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

public class MovingTest extends BaseIjTestClass {

    private static String carText;
    private static String driverText;
    private static TestClass driverClass;
    private static TestClass carClass;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path carPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/Car.java");
        carText = Files.readString(carPath);
        Path driverPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/Driver.java");
        driverText = Files.readString(driverPath);
        driverClass = new TestClass(
                "Driver",
                "jetbrains.refactoring.course.moving",
                Visibility.PUBLIC,
                ClassType.CLASS,
                List.of(
                        new TestVariable(
                                "car",
                                "Car",
                                null,
                                Visibility.PRIVATE,
                                false,
                                true,
                                false
                        )
                ),
                List.of(
                        new TestMethod(
                                "changeCar",
                                "void",
                                List.of(
                                        new TestVariable("car", "Car")
                                ),
                                Visibility.PUBLIC
                        ),
                        new TestMethod(
                                "driving",
                                "void",
                                List.of(new TestVariable("destination", "String")),
                                Visibility.PRIVATE
                        ),
                        new TestMethod(
                                "driveTo",
                                "void",
                                List.of(new TestVariable("destination", "String")),
                                Visibility.PUBLIC
                        ),
                        new TestMethod(
                                "start",
                                "void",
                                emptyList(),
                                Visibility.PRIVATE
                        ),
                        new TestMethod(
                                "stop",
                                "void",
                                emptyList(),
                                Visibility.PRIVATE
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );

        carClass = new TestClass(
                "Car",
                "jetbrains.refactoring.course.moving",
                Visibility.PUBLIC,
                ClassType.CLASS,
                List.of(
                        new TestVariable(
                                "gearsNumber",
                                "int",
                                null,
                                Visibility.PRIVATE,
                                true,
                                true,
                                false
                        ),
                        new TestVariable(
                                "engineStarted",
                                "boolean",
                                "false",
                                Visibility.PRIVATE,
                                false,
                                false,
                                false
                        ),
                        new TestVariable(
                                "gear",
                                "int",
                                "0",
                                Visibility.PRIVATE,
                                false,
                                false,
                                false
                        )
                ),
                List.of(
                        new TestMethod(
                                "setGear",
                                "void",
                                List.of(
                                        new TestVariable("gear", "int")
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
    public void testCarClassMoved() throws Exception {
        setUp();
        myFixture.configureByText("Car.java", carText);
        Assertions.assertTrue(hasClass("Car"),
                "Please, move the Car class to a separate file in the car package");
    }

    @Test
    public void testDriverClassMoved() throws Exception {
        setUp();
        myFixture.configureByText("Driver.java", driverText);
        Assertions.assertTrue(hasClass("Driver"),
                "Please, move the Driver class to a separate file in the driver package");
    }

    @Test
    public void driverClassTest() {
        try {
            driverClass.checkBaseDefinition();
        } catch (Exception e) {
            Assertions.fail("Please, change the visibility of the Driver class to public");
        }
    }

    @Test
    public void carClassTest() {
        try {
            carClass.checkBaseDefinition();
        } catch (Exception e) {
            Assertions.fail("Please, change the visibility of the Car class to public");
        }
    }
}
