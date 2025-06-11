Task 1/4: What is formatting?

**_Code style_** is a set of guidelines used in a development team on how to write code.
Usually, the code style depends on the programming language and developers’ preferences and includes rules about formatting,
documentation, naming conventions, and other aspect that affect code readability.

**_Code formatting_** refers to the arrangement of code, including indentation, spacing, line breaks, and other stylistic conventions.
Consistent indentation, clear spacing, and logical line breaks help developers quickly understand the code structure,
flow, and relationships between different code elements.

Let's take a look at the two simple code snippets.

**Before fixing formatting:**
```java
public class Main {
    public static void main(String[] args){
        double l = 5.0; double w = 3.0; double area = calculateRectangleArea(l, w);
        System.out.println("Rectangle area: " + area);
    }

    public static double calculateRectangleArea(double length,double width){
        return length*width; }
}
```
This code snippet doesn't have consistent indentation and proper spacing, making the code difficult to read and understand.

**After fixing formatting:**
```java
public class Main {
    public static void main(String[] args) {
        double rectangleLength = 5.0;
        double rectangleWidth = 3.0;
        double area = calculateRectangleArea(rectangleLength, rectangleWidth);
        System.out.println("Rectangle area: " + area);
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}
```
The **refactored version** demonstrates improved formatting and naming, leading to enhanced readability and maintainability.

<div class="hint" title="Code Formatting's Role in Code Review">

One of the examples that shows how a lack of consistency might be confusing is the code review process.
In real life, developers use version control systems to share their code with colleagues, and **inconsistent formatting
makes the code review process more complicated**.
Imagine you and your colleague use different formatting styles, and your colleague makes a minor change in the code but
then formats the code according to their style.
It will lead to the situation when you see lots of code line changes, but in fact, only a couple of lines contain functional changes.
It is one of the examples of why you should pay attention to formatting.
</div>
