import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InliningTest extends BaseIjTestClass {

    private static String sourceText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/inlining/Task.java");
        sourceText = Files.readString(sourceCodeFilePath);
    }

    @Test
    public void testDeletedVariablesAndMethods() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        Assertions.assertFalse(hasLocalVariable("text"),
                "Please, identify unnecessary variables");
        Assertions.assertFalse(hasLocalVariable("fileWriter"),
                "Please, identify unnecessary variables");
        Assertions.assertFalse(hasMethod("getBufferedWriter"),
                "Please, identify unnecessary methods");
    }

    @Test
    public void testExpressionCallIsReplacedByItsBody() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", sourceText);
        String expression = "bufferedWriter.write(\"Hello  World!\")";
        String parent = "bufferedWriter.write(\"Hello  World!\");";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, false),
                "Please, replace the \"text\" variable call by its body - " + expression);
        expression = "new BufferedWriter(new FileWriter(\"file.txt\"))";
        parent = "main";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, true),
                "Please, replace the \"getBufferedWriter\" method call by its body - " + expression);
    }
}
