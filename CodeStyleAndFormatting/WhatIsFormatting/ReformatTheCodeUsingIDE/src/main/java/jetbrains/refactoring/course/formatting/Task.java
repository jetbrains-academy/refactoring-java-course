package jetbrains.refactoring.course.formatting;

public class Task {
    public static void main(String[] args) {
        funWithFormattingIssues();
    }

    public static void funWithFormattingIssues() {
        System.out.println("This function definitely has formatting issues");
        System.out.println("... that could be easily fixed using one shortcut");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Please, format me!");
        }
    }
}