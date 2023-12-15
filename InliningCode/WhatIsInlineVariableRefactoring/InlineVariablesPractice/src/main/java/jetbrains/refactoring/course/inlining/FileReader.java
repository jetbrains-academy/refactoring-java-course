package jetbrains.refactoring.course.inlining;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    public String readFileContent(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at path: " + path);
        }
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        return String.join("\n", lines);
    }
}