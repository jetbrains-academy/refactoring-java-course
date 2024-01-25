package jetbrains.refactoring.course.moving;

public class Main {
   public static void main(String[] args) {
      Car car = new Car(5);
      Driver driver = new Driver(car);
      driver.driveTo("Belgrade");
   }
}
