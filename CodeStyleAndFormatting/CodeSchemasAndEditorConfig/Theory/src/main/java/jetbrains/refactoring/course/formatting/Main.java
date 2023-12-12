package jetbrains.refactoring.course.formatting;

public class Main {
   public static void main(String[] args) {
      funWithCodeStyleIssues();
   }

   public static void funWithCodeStyleIssues() {
      System.out.println("What is the indent size in this file?");
      System.out.println("What indent size should be according to .editorconfig?");
      for (int i = 1; i <= 10; i++) {
         System.out.println("Please, fix me!");
      }
   }
}
