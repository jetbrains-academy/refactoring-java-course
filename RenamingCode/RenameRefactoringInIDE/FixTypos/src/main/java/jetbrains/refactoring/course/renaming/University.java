package jetbrains.refactoring.course.renaming;

import java.util.ArrayList;

public class University {
    private final ArrayList<Student> students = new ArrayList<>();

    public void admitStudent(String name, int age, double averageScore) {
        Student student = new Student(name, age, averageScore);
        students.add(student);
    }

    public void updateStudentInfo(int index, String newName, int newAge, double newScore) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            student.setName(newName);
            student.setAge(newAge);
            student.setAverageScore(newScore);
        }
    }

    public String getStudentGradeStatus(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index).getGradeStatus();
        }
        return "Invalid index";
    }
}
