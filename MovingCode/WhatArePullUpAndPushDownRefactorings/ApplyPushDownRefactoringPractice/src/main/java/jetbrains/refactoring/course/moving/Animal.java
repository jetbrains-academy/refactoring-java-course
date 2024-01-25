package jetbrains.refactoring.course.moving;

public abstract class Animal {

    protected final String name;
    protected final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }

    void play() {
        System.out.println(name + " is playing.");
    }
}
