package jetbrains.refactoring.course.moving;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    void meow() {
        System.out.println(name + " is meowing.");
    }
}
