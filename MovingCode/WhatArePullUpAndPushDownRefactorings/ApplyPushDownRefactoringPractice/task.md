### Task

In the `Animal` file, there are methods that are common for all animal types, such as `sleep()` and `eat()`.
You need to identify methods that are specific for certain animals and apply the Push Down refactoring
to move them from the base interface to the corresponding classes.

### Hints

<div class="hint" title="Shortcut for Push Down refactorings">

Use the &shortcut:Refactorings.QuickListPopupAction; (macOS) or `Shift+Ctrl+Alt+T` (Windows/Linux) shortcut to Push Down a code element.
</div>

<div class="hint" title="Refactoring Hint">

Make sure that you deleted irrelevant methods in the `Cat` and `Dog` classes after refactoring.
For example, the `meow()` method should only exist within the `Cat` class.
</div>
