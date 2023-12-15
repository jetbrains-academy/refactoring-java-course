import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ExtractingTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/extracting/Task.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testExtractedFunction() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        String expected =
                "Path path = Paths.get(filename);\n" +
                "if (!Files.exists(path) || !Files.isReadable(path)) {\n" +
                "    throw new IOException(\"File \" + filename + \" does not exist or is not accessible for read.\");\n" +
                "}\n" +
                "return path;\n";
        List<String> methodNames = findMethodsWithContent(expected);
        Assertions.assertFalse(methodNames.size() > 1,
                "Please, extract duplicated code into separate function");
        Assertions.assertFalse(methodNames.isEmpty(),
                "Please, extract the code that checks if the file exists and is valid");
        String extractedMethod = methodNames.get(0) + "(filename)";
        List<String> methodsUsingExtractedMethod = findMethodUsages(extractedMethod);
        Assertions.assertEquals(Arrays.asList("processTextFile", "processImageFile"), methodsUsingExtractedMethod,
                extractedMethod + " function must be called in the functions from which the code was extracted");
    }
}
