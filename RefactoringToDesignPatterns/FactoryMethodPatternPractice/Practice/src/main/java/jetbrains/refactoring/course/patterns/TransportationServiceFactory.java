package jetbrains.refactoring.course.patterns;

public class TransportationServiceFactory {

    public Transport getTransportation(String transport) {
        switch (transport) {
            case "car":
                return new Car();
            case "bicycle":
                return new Bicycle();
            default:
                throw new IllegalArgumentException("Unknown transport");
        }
    }
}
