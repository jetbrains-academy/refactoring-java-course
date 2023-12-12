package jetbrains.refactoring.course.patterns;

public class Main {
   public static void main(String[] args) {
      String transportName = args[0];
      Transport transport;
      if ("car".equals(transportName)) {
         transport = new Car();
      } else if ("bicycle".equals(transportName)) {
         transport = new Bicycle();
      } else {
         throw new IllegalArgumentException("Unknown transport");
      }
      String driveMessage = transport.drive();
      System.out.println(driveMessage);
   }
}
