package jetbrains.refactoring.course.moving;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void play() {
        System.out.println(name + " is playing.");
    }
}
