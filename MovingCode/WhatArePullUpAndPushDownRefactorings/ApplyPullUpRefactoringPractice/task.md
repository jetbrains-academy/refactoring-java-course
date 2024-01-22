### Task

In this task, there are three files:
- `Animal` - the base interface for different animal types, it contains several methods.
- `Cat` - represents a cat and implements the Animal interface.
- `Dog` - represents a dog and implements the Animal interface.

Take a look at the `Cat` and `Dog` classes and identify any methods and properties that are not specific to animal type.
Move them to the base interface `Animal` by using the Pull Up refactoring.

### Hints

<div class="hint" title="Shortcut for Pull Up refactorings">

Use the &shortcut:Refactorings.QuickListPopupAction; (macOS) or `Shift+Ctrl+Alt+T` (Windows/Linux) shortcut to Pull Up a code element.

</div>

<div class="hint" title="Refactoring Hint">

Pull Up the `play()` method to the `Animal` interface and add the `override` modifier before its implementations in both the `Cat` and `Dog` classes.
</div>
