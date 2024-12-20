Task 1/1: Getting familiar with IDE refactoring features

There are two places to explore available refactoring actions in the IDE: the **Refactor This** and **Search Everywhere**
dialogs.

### Refactor This
To invoke refactoring in IntelliJ IDEA, select an item to refactor (a variable, method, class, package, etc.)
and press **&shortcut:Refactorings.QuickListPopupAction;** (macOS) or **Shift+Ctrl+Alt+T** (Windows/Linux) to open a
list of
applicable refactorings.
You can also use a shortcut to invoke a specific refactoring.

It is possible to undo any refactoring by pressing **&shortcut:$Undo;** (macOS) or **Ctrl + Z** (Windows/Linux).

<p align="center">
    <img src="../../../common/src/main/resources/images/RefactoringAndItsPurpose/GettingFamiliarWithIDERefactoringFeatures/refactor_this.png" alt="Refactor This" width="400"/>
</p>

### Search Everywhere
If you want to refactor some code and are unfamiliar with the IDE’s refactoring shortcuts, you can open the **Search
Everywhere** dialog and type the name of the action you would like to perform.

To open the **Search Everywhere** dialog, press **⇧⇧** (macOS) or **Shift+Shift** (Windows/Linux).

For example, if you want to extract a function or explore any extraction possibilities in the IDE,
open the **Search Everywhere** dialog, type “Extract”, and it will show the available options.
<p align="center">
    <img src="../../../common/src/main/resources/images/RefactoringAndItsPurpose/GettingFamiliarWithIDERefactoringFeatures/search_everywhere.png" alt="Search Everywhere" width="400"/>
</p>

Moreover, for some refactorings, IntelliJ IDEA allows users to preview the changes before applying them.
It could be useful if you are not sure how refactoring changes would affect your code and want to make sure that it
will work as expected.

### Refactoring shortcuts
Here is a table with the most popular refactorings and shortcuts to invoke them:

| Refactoring type       | Description                                                            | Shortcut                                                            |
|------------------------|------------------------------------------------------------------------|---------------------------------------------------------------------|
| **Refactor This**      | Shows available refactoring options.                                   | ⌃T (macOS) or Shift+Ctrl+Alt+T (Windows/Linux)                      |
| **Rename**             | Changes the name of a code element.                                    | &shortcut:RenameElement; (macOS) or Shift+F6 (Windows/Linux)        |
| **Change Signature**   | Allows to change the method’s name, parameters, and return type.       | &shortcut:ChangeSignature; (macOS) or Ctrl+F6 (Windows/Linux)       |
| **Introduce Variable** | Extracts a value into a new variable.                                  | &shortcut:IntroduceVariable; (macOS) or Ctrl+Alt+V  (Windows/Linux) |
| **Inline**             | Removes a variable/method and puts its body to the place it’s used at. | &shortcut:Inline; (macOS) or Ctrl+Alt+N (Windows/Linux)             |
| **Extract Function**   | Creates a new method and moves a selected piece of code to it.         | &shortcut:ExtractMethod; (macOS) or Ctrl+Alt+M (Windows/Linux)      |
| **Move**               | Moves a method/class to another place in the codebase.                 | &shortcut:DatabaseView.MoveToGroup; (macOS) or F6 (Windows/Linux)   |

We will discuss these and other refactorings in the following lessons.

**See Also**: [IntelliJ IDEA keyboard shortcuts sheet](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
