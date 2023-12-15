import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.jetbrains.academy.test.system.ij.formatting.FormattingUtilKt.checkIfFormattingRulesWereApplied;

public class ReformatTheCodeTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath, "src/main/java/jetbrains/refactoring/course/formatting/Task.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testSolutionIsFormatted() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        checkIfFormattingRulesWereApplied(myFixture.getFile());
    }
}
