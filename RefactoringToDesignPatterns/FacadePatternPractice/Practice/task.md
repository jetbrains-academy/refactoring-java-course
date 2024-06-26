### Task

- Create a class named `VideoConversionFacade`.
  This class should provide a simplified interface for video conversion, encapsulating the intricacies of the conversion
  process.

- Then, within the `Main::main()` method, identify the statements specifically related to video conversion – these
  should
  cover the loading, processing, encoding, and saving of the video. After identifying them, extract these statements into a new
  method.
  Name this method `convertVideo` and ensure it accepts two parameters, both of the `String` type.
  Then, move this method to the `VideoConversionFacade` class and make it `public`.

- Additionally, transfer the declarations for `videoLoader`, `videoProcessor`, `videoEncoder`,
  and `videoSaver` to become `private` properties of the `VideoConversionFacade` class.

- Finally, change the main method: it should create an instance of the `VideoConversionFacade` class and invoke
  the `convertVideo` method.

### Hints

<div class="hint" title="Where to start?">

The file where you should write the code is already open.
Please create a new empty class named `VideoConversionFacade`.
</div>

<div class="hint" title="Refactoring hint">

In the `Main` file, identify the statements within the `main` method that handle video conversion.
Apply the extract method refactoring to these statements and name the resulting method `convertVideo`.
Then, you'll need to manually transfer this newly-formed method to the `VideoConversionFacade` class.

</div>

<div class="hint" title="How to fix main method?">

In the `main` method, you need to create a new instance of the `VideoConversionFacade` class and then call
the `convertVideo` method, passing in two parameters: `originalMethodName` and `convertedMethodName`.
</div>
