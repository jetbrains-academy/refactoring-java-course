import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.jetbrains.academy.test.system.ij.formatting.FormattingUtilKt.checkIfFormattingRulesWereApplied;

public class ReformatCodeBasedOnEditorConfigSettingsTest extends BaseIjTestClass {

    private static String sourceText;
    private static String editorConfigSettingsText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path sourceCodeFilePath = Paths.get(taskDirectoryPath, "src/main/java/jetbrains/refactoring/course/formatting/Main.java");
        sourceText = Files.readString(sourceCodeFilePath);
        Path editorConfigSettingsPath = Paths.get(taskDirectoryPath, ".editorconfig");
        editorConfigSettingsText = Files.readString(editorConfigSettingsPath);
    }

    @Test
    public void testSolutionIsFormattedAccordingToEditorConfigSettings() throws Exception {
        setUp();
        VirtualFile editorConfigFile = myFixture.createFile(".editorconfig", editorConfigSettingsText);
        myFixture.addFileToProject(editorConfigFile.getPath(), editorConfigSettingsText);
        myFixture.configureByText("Task.java", sourceText);
        checkIfFormattingRulesWereApplied(myFixture.getFile());
    }
}
