import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MiddleManTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/inlining/Main.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testMiddleManClassRemoved() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertFalse(hasClass("MiddleMan"), "Please, remove \"MiddleMan\" class");
    }

    @Test
    public void testMethodCallExists() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertTrue(hasExpressionWithParent("dataProvider.fetchData()", "processData", true),
          "Please, invoke \"dataProvider.fetchData()\" inside \"Client::processData\" method.");
    }
}
