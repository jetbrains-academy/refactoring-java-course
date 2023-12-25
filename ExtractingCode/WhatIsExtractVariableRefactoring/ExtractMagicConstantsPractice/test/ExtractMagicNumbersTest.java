import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtractMagicNumbersTest extends BaseIjTestClass {

    private static String sourceText;
    private static final String SPEED_OF_LIGHT = "299792458.0";
    private static final String PLANCK_CONSTANT = "6.62607015e-34";

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/extracting/Task.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testExtractedConstant() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertTrue(hasConstantWithGivenValue(SPEED_OF_LIGHT),
                "Please, create constant values for " + SPEED_OF_LIGHT);
        Assertions.assertTrue(hasConstantWithGivenValue(PLANCK_CONSTANT),
                "Please, create constant values for " + PLANCK_CONSTANT);
        String propertyName = "waveLength";
        Assertions.assertTrue(hasLocalVariable(propertyName),
                "Please, create property for " + propertyName);
    }
}
