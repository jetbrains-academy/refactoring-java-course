package jetbrains.refactoring.course.patterns;

public class TransportationServiceFactory {

    public Transport getTransportation(String transport) {
        return switch (transport) {
            case "car" -> new Car();
            case "bicycle" -> new Bicycle();
            default -> throw new IllegalArgumentException("Unknown transport");
        };
    }
}
