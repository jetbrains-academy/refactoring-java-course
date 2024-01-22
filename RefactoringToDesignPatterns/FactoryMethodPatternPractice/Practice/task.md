### Task

- Create a class named `TransportationServiceFactory` with a method called `getTransportation(String transport)`.
  This method should return the appropriate transportation based on the given transport name, using the `switch`
  construction.

- In the main method, create an instance of the `TransportationServiceFactory` class, add an invocation of
  the `getTransportation` method, and invoke the `drive` method.

### Hints

<div class="hint" title="Where to start?">

The file where you should write the code is already open.
Please create a new class named `TransportationServiceFactory` and implement the `getTransportation` method.
</div>

<div class="hint" title="How should TransportationServiceFactory class look?">

Examine the code in the `main` method to identify the lines that create specific transports based on their names.
Then, move those lines manually to the `getTransportation(String transport)` method in the `TransportationServiceFactory` class.

</div>

<div class="hint" title="How to fix main method?">

```java
public class Main {
  public static void main(String[] args) {
    String transportName = args[0];
    TransportationServiceFactory factory = new TransportationServiceFactory();
    String driveMessage = factory.getTransportation(transportName).drive();
    System.out.println(driveMessage);
  }
}
```

</div>
