package jetbrains.refactoring.course.extracting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task {
    public static Path getValidatedPath(String filename) throws IOException {
        Path path = Paths.get(filename);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            throw new IOException("File " + filename + " does not exist or is not accessible for read.");
        }
        return path;
    }

    public static void processTextFile(String filename) throws IOException {
        Path path = getValidatedPath(filename);
        String content = Files.readString(path);
        System.out.println("Content of the text file: " + content);
    }

    public static void processImageFile(String filename) throws IOException {
        Path path = getValidatedPath(filename);
        BufferedImage image = ImageIO.read(path.toFile());
        ImageIO.write(image, "jpg", Paths.get("newImage.jpg").toFile());
        System.out.println("The image has been saved in a new format.");
    }
}
