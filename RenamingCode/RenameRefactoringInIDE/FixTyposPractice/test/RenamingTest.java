import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenamingTest extends BaseIjTestClass {

    private static String studentText;
    private static String universityText;

    @BeforeAll
    static void beforeAll() throws IOException {
        String taskDirectoryPath = System.getProperty("user.dir");
        Path studentPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/renaming/Student.java");
        studentText = Files.readString(studentPath);
        Path universityPath = Paths.get(taskDirectoryPath,
                "src/main/java/jetbrains/refactoring/course/renaming/University.java");
        universityText = Files.readString(universityPath);
    }

    @Test
    public void testRenamingMethodNames() throws Exception {
        setUp();
        myFixture.configureByText("Student.java", studentText);
        Assertions.assertTrue(hasMethod("getGradeStatus"),
                "Please, change method name according to the сamelCase style - getgradestatus");
        Assertions.assertTrue(hasMethod("setName"),
                "Please, change method name according to the сamelCase style - SetName");
        Assertions.assertTrue(hasMethod("setAge"),
                "Please, change method name according to the сamelCase style - setaGe");
        Assertions.assertTrue(hasMethod("setAverageScore"),
                "Please, fix the typos in the method name - setAvergeScore");
    }

    @Test
    public void testRenamingMethodCalls() throws Exception {
        setUp();
        myFixture.configureByText("University.java", universityText);
        var expression = "student.setName(newName)";
        var parent = "student.setName(newName);";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, false),
                "Please, rename the method calls too");
        expression = "student.setAge(newAge)";
        parent = "student.setAge(newAge);";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, false),
                "Please, rename the method calls too");
        expression = "student.setAverageScore(newScore)";
        parent = "student.setAverageScore(newScore);";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, false),
                "Please, rename the method calls too");
        expression = "students.get(index)";
        parent = "students.get(index).getGradeStatus";
        Assertions.assertTrue(hasExpressionWithParent(expression, parent, false),
                "Please, rename the method calls too");
    }
}
