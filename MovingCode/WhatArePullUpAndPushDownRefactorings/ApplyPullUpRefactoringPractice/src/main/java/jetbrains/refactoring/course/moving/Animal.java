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

    void bark() {
        System.out.println(name + " is barking.");
    }

    void meow() {
        System.out.println(name + " is meowing.");
    }

    void play() {
        System.out.println(name + " is playing.");
    }
}
