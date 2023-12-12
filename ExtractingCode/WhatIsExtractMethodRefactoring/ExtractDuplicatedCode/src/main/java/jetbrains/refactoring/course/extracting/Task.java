package jetbrains.refactoring.course.extracting;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task {
    public static File getValidatedFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException();
        }
        return file;
    }

    public static int wordCount(String fileName) throws Exception {
        getValidatedFile(fileName);
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        int wordCount = 0;
        for (String line : lines) {
            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }

    public static void copyFile(String srcName, String destName) throws Exception {
        File file = getValidatedFile(srcName);
        File toFile = new File(destName);
        Files.copy(file.toPath(), toFile.toPath());
    }
}