package jetbrains.refactoring.course.renaming;

public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getGradeStatus() {
        if (averageScore >= 90.0 && averageScore <= 100.0) {
            return "Excellent";
        } else if (averageScore >= 80.0 && averageScore < 90.0) {
            return "Good";
        } else if (averageScore >= 70.0 && averageScore < 80.0) {
            return "Average";
        } else {
            return "Fail";
        }
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setAverageScore(double newScore) {
        this.averageScore = newScore;
    }
}
