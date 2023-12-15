import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IdentifyIssuesInCodeSnippetTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath, "src/main/java/jetbrains/refactoring/course/refactoring/purpose/Task.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testRedundantVariablesRemoved() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertFalse(hasLocalVariable("length"), "Please, remove redundant variable \"length\"");
        Assertions.assertFalse(hasLocalVariable("width"), "Please, remove redundant variable \"width\"");
        Assertions.assertFalse(hasLocalVariable("result"), "Please, remove redundant variable \"result\"");
    }

    @Test
    public void testMethodAndParametersRenamed() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertTrue(hasMethod("calculateArea"), "Please, rename method \"calculate_area\" to \"calculateArea\"");
        Assertions.assertFalse(hasParameter("l"), "Please, rename \"l\" parameter to \"length\"");
        Assertions.assertFalse(hasParameter("w"), "Please, rename \"w\" parameter to \"width\"");
    }
}
