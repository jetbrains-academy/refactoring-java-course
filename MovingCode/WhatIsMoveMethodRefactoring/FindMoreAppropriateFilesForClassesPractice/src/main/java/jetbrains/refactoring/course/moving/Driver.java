package jetbrains.refactoring.course.moving;

public class Driver {
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
