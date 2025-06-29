Task 1/2: What is Extract Method refactoring?

As we mentioned before, **duplicated code can lead to undesirable effects**. For example, if you fix a bug in one place
but forget to fix it consistently in duplicates,
the bug will still remain, and now it is even harder to find.

We recommend avoiding duplicated code, but what can you do if it already exists?
The solution is to **extract the duplicated code into a new separate function** and replace all the duplicated code fragments
with calls to the newly introduced function.
It is called the **Extract Method**.

Also, we apply the Extract Method refactoring when we encounter **long methods**.
While there's no fixed limit on a method's line count should have, **consider extracting
a block of code statements into a separate method** if those statements are cohesive
and represent a piece of functionality that could be reused elsewhere.
This also improves code readability and organization.

Smaller functions make the code easier to read and understand, as each method has one single responsibility,
making the overall flow more evident.
