package jetbrains.refactoring.course.refactoring.purpose;

public class Task {
    public static void main(String[] args) {
        System.out.println(calculateArea(5.0, 8.0));
    }

    public static double calculateArea(double length, double width) {
        return length * width;
    }
}