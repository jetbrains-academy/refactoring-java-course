import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PushDownTest extends BaseIjTestClass {

    private static String animalText;
    private static String dogText;
    private static String catText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path animalPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/Animal.java");
        animalText = Files.readString(animalPath);
        Path dogPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/Dog.java");
        dogText = Files.readString(dogPath);
        Path catPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/moving/Cat.java");
        catText = Files.readString(catPath);
    }

    @Test
    public void testPushDownMeowMethod() throws Exception {
        setUp();
        myFixture.configureByText("Animal.java", animalText);
        Assertions.assertFalse(hasMethod("meow"),
                "Please, push down the \"meow\" method");
        myFixture.configureByText("Dog.java", dogText);
        Assertions.assertFalse(hasMethod("meow"),
                "Please, remove the \"meow\" method from the Dog class");
    }

    @Test
    public void testPushDownBarkMethod() throws Exception {
        setUp();
        myFixture.configureByText("Animal.java", animalText);
        Assertions.assertFalse(hasMethod("bark"),
                "Please, push down the \"bark\" method");
        myFixture.configureByText("Cat.java", catText);
        Assertions.assertFalse(hasMethod("bark"),
                "Please, remove the \"bark\" method from the Cat class");
    }
}
