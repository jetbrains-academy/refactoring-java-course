package jetbrains.refactoring.course.moving;

public class Main {
   public static void main(String[] args) {
      Car car = new Car(5);
      Driver driver = new Driver(car);
      driver.driveTo("Belgrade");
   }
}

class Car {
   private final int gearsNumber;
   public boolean engineStarted = false;
   private int gear = 0;

   public Car(int gearsNumber) {
      this.gearsNumber = gearsNumber;
   }

   public void setGear(int gear) {
      if (gear > gearsNumber || gear < 0) {
         throw new IllegalStateException();
      }
      this.gear = gear;
   }
}

/** Represents a driver */
class Driver {
   private Car car;

   public Driver(Car car) {
      this.car = car;
   }

   public void changeCar(Car car) {
      this.car = car;
   }

   private void start() {
      car.engineStarted = true;
      car.setGear(1);
   }

   private void stop(){
      car.setGear(0);
      car.engineStarted = false;
   }

   private void driving(String destination){
      System.out.println("The driver is coming to " + destination);
   }

   public void driveTo(String destination) {
      System.out.println("Start driving");
      start();
      driving(destination);
      stop();
      System.out.println("Arrived at destination");
   }
}
