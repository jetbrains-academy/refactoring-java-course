# Task 2/2: Inline methods and variables

### Task

In this task, you need to identify unnecessary variables and method and inline them using the automatic Inline
refactoring.

### Hints

<div class="hint" title="Shortcut for Inline refactoring">
To apply the Inline refactoring, select the code you want to inline and press the &shortcut:Inline; (macOS) or 
Ctrl+Alt+N (Windows/Linux) shortcut. 
</div>

<div class="hint" title="Refactoring hint">

The variable `text` in the method `main` is redundant and could be inlined.

The variables `fileWriter` and `bufferedWriter` in the method `getBufferedWriter` are redundant and could be inlined.

Since the method `getBufferedWriter` contains only one line and is used only in one method, it could also be inlined.

</div>
