package jetbrains.refactoring.course.moving;

import jetbrains.refactoring.course.moving.car.Car;
import jetbrains.refactoring.course.moving.driver.Driver;

public class Main {
   public static void main(String[] args) {
      Car car = new Car(5);
      Driver driver = new Driver(car);
      driver.driveTo("Belgrade");
   }
}
