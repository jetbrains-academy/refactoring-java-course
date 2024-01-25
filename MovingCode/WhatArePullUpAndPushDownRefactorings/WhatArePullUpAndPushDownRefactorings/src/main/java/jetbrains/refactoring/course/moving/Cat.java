package jetbrains.refactoring.course.moving;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void play() {
        System.out.println(name + " is playing.");
    }
}
