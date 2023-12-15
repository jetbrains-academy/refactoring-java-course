import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;

public class EditorconfigTest {

    private static File editorconfigFile;

    @BeforeAll
    static void beforeAll() {
        String taskDirectoryPath = System.getProperty("user.dir");
        editorconfigFile = new File(taskDirectoryPath + "/.editorconfig");
    }

    @Test
    public void editorconfigFileCreatedTest() {
        Assertions.assertTrue(editorconfigFile.exists());
    }

    @Test
    public void editorconfigFileContentTest() throws IOException {
        Ini ini = new Ini(editorconfigFile);
        Assertions.assertEquals("4", ini.get("*").get("indent_size"),
            "Please, define the settings so that the indentation size is equal to 4");
        Assertions.assertEquals("space", ini.get("*").get("indent_style"),
            "Please, define the settings so that the indentation style is equal to space");
        Assertions.assertEquals("120", ini.get("*").get("max_line_length"),
            "Please, define the settings so that the maximum line length is equal to 120");
        Assertions.assertEquals("true", ini.get("*").get("insert_final_newline"),
            "Please, define the settings so that a newline character is added at the end of the last line in the file");
    }
}
