import org.jetbrains.academy.test.system.core.models.Visibility;
import org.jetbrains.academy.test.system.core.models.classes.ClassType;
import org.jetbrains.academy.test.system.core.models.classes.TestClass;
import org.jetbrains.academy.test.system.core.models.method.TestMethod;
import org.jetbrains.academy.test.system.core.models.variable.TestVariable;
import org.jetbrains.academy.test.system.java.test.BaseIjTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Collections.emptyList;

public class FacadePatternTest extends BaseIjTestClass {

    private static String facadeText;

    private static TestClass facadeClass;

    @BeforeAll
    static void beforeAll() throws IOException {
          String taskDirectoryPath = System.getProperty("user.dir");
          Path facadeFilePath = Paths.get(taskDirectoryPath,
                  "src/main/java/jetbrains/refactoring/course/patterns/VideoConversionFacade.java");
          facadeText = Files.readString(facadeFilePath);

        facadeClass = new TestClass(
                "VideoConversionFacade",
                "jetbrains.refactoring.course.patterns",
                Visibility.PUBLIC,
                ClassType.CLASS,
                List.of(
                        new TestVariable(
                                "videoLoader",
                                "VideoLoader",
                                "new VideoLoader()",
                                Visibility.PRIVATE,
                                true,
                                false,
                                false
                        ),
                        new TestVariable(
                                "videoProcessor",
                                "VideoProcessor",
                                "new VideoProcessor()",
                                Visibility.PRIVATE,
                                true,
                                false,
                                false
                        ),
                        new TestVariable(
                                "videoEncoder",
                                "VideoEncoder",
                                "new VideoEncoder()",
                                Visibility.PRIVATE,
                                true,
                                false,
                                false
                        ),
                        new TestVariable(
                                "videoSaver",
                                "VideoSaver",
                                "new VideoSaver()",
                                Visibility.PRIVATE,
                                true,
                                false,
                                false
                        )
                ),
                List.of(
                        new TestMethod(
                                "convertVideo",
                                "void",
                                List.of(
                                        new TestVariable("originalVideoName", "String"),
                                        new TestVariable("processedVideoName", "String")
                                ),
                                Visibility.PUBLIC
                        )
                ),
                false,
                emptyList(),
                emptyList()
        );
    }

    @Test
    public void videoConversionFacadeClassTest() throws Exception {
        setUp();
        myFixture.configureByText("Task.java", facadeText);
        String className = "VideoConversionFacade";
        Assertions.assertTrue(hasClass(className), "Please, create the class " + className);
        String methodName = "convertVideo";
        Assertions.assertTrue(hasMethod(methodName), "Please, create the method " + methodName);
        String propertyName = "videoLoader";
        Assertions.assertTrue(hasField(propertyName), "Please, create the property " + propertyName);
        propertyName = "videoProcessor";
        Assertions.assertTrue(hasField(propertyName), "Please, create the property " + propertyName);
        propertyName = "videoEncoder";
        Assertions.assertTrue(hasField(propertyName), "Please, create the property " + propertyName);
        propertyName = "videoSaver";
        Assertions.assertTrue(hasField(propertyName), "Please, create the property " + propertyName);
        Assertions.assertTrue(hasExpressionWithParent("videoLoader.loadVideo", "convertVideo", true),
                "Please, extract the statements related to loading the video into the \"convertVideo\" method.");
        Assertions.assertTrue(hasExpressionWithParent("videoProcessor.processVideo", "convertVideo", true),
                "Please, extract the statements related to processing the video into the \"convertVideo\" method.");
        Assertions.assertTrue(hasExpressionWithParent("videoEncoder.encodeVideo", "convertVideo", true),
                "Please, extract the statements related to encoding the video into the \"convertVideo\" method.");
        Assertions.assertTrue(hasExpressionWithParent("videoSaver.saveVideo", "convertVideo", true),
                "Please, extract the statements related to saving the video into the \"convertVideo\" method.");

        Class<?> clazz = facadeClass.checkBaseDefinition();
        facadeClass.checkFieldsDefinition(clazz, true);
        facadeClass.checkDeclaredMethods(clazz);
    }
}
