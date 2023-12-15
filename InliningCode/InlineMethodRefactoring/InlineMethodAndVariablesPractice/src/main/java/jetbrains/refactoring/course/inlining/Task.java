package jetbrains.refactoring.course.inlining;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Task {

    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"))) {
            bufferedWriter.write("Hello  World!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
