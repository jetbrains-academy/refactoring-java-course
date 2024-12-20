Task 1/2: What is code refactoring?

**_Refactoring_** is a process of modifying source code without changing its behavior. For example, this could involve renaming a method or
extracting a _magic constant_ into a separate variable. It improves code readability but doesn’t change what the code does.

The purpose of refactoring is to **improve code readability and simplify its maintenance**. Since software developers often
work in teams on codebases and spend considerable time reading each other’s code, it is important to make your code
clear and clean.

Let's take a look at two code snippets below.

**Before refactoring:**

```java
public class Main {
    
    public static void main(String[] args) {
        double n = 5.0;
        double result = calculate(n);
        System.out.println("Circle area is: " + result);
    }

    public static double calculate(double r) {
        return 3.14159 * r * r;
    }
}
```

In this snippet of code, the method name `calculate` isn't descriptive, making it unclear what it calculates.
The variable `n` and the method parameter `r` don't provide any information about their purpose.
The constant `3.14159` is hard-coded within the method, leading to lack of clarity.

**After refactoring:**

```java
public class Main {

    public static final double PI_VALUE = 3.14159;

    public static void main(String[] args) {
        double circleRadius = 5.0;
        double area = calculateCircleArea(circleRadius);
        System.out.println("Circle area is: " + area);
    }

    public static double calculateCircleArea(double radius) {
        return PI_VALUE * radius * radius;
    }
}
```

To improve the readability of the original snippet of code, the following refactorings were applied:

- The method `calculate` was **renamed** to `calculateCircleArea` to better express its purpose: calculating the area of a
  circle.
- The variable `n` was **renamed** to `circleRadius` for better code clarity.
- The parameter `r` was **renamed** to `radius` to improve code clarity.
- A `PI_VALUE` constant was **extracted** to hold the value of `Pi`, making the calculation formula more
  understandable and reusable.
