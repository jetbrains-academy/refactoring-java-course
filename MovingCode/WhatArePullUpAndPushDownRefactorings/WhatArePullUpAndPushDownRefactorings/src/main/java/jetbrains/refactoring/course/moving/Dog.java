package jetbrains.refactoring.course.moving;

public class Dog implements Animal {

    private final String name;
    private final int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(name + " the dog is eating.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " the dog is sleeping.");
    }

    @Override
    public void bark() {
        System.out.println(name + " the dog is barking.");
    }

    @Override
    public void meow() {
        System.out.println(name + " the animal is meowing.");
    }

    public void play() {
        System.out.println(name + " the dog is playing.");
    }
}
