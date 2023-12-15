package jetbrains.refactoring.course.patterns;

public class Main {
   public static void main(String[] args) {
      String transportName = args[0];
      TransportationServiceFactory factory = new TransportationServiceFactory();
      String driveMessage = factory.getTransportation(transportName).drive();
      System.out.println(driveMessage);
   }
}
