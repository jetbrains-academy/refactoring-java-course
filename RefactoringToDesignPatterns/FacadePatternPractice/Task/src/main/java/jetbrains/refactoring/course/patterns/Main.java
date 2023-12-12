package jetbrains.refactoring.course.patterns;

public class Main {
   public static void main(String[] args) {
      String originalVideoName = args[0];
      String processedVideoName = args[1];

      VideoConversionFacade facade = new VideoConversionFacade();
      facade.convertVideo(originalVideoName, processedVideoName);
   }
}