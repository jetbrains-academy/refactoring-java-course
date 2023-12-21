import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InliningVariableTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/inlining/FileReader.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testVariablesInlined() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertFalse(hasLocalVariable("fileExists"),
            "Please, inline the \"fileExists\" variable");
        Assertions.assertFalse(hasLocalVariable("content"),
            "Please, inline the \"content\" variable");
    }
}
