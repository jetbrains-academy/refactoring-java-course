package jetbrains.refactoring.course.moving;

public class Driver {
    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void changeCar(Car car) {
        this.car = car;
    }

    private void driving(String destination){
        System.out.println("The driver is coming to " + destination);
    }

    public void driveTo(String destination) {
        System.out.println("Start driving");
        car.start();
        driving(destination);
        car.stop();
        System.out.println("Arrived at destination");
    }
}
