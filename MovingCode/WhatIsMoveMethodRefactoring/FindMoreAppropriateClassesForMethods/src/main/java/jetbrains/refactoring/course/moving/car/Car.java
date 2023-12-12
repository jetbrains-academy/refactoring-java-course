package jetbrains.refactoring.course.moving.car;

public class Car {
    private final int gearsNumber;
    private boolean engineStarted;
    private int gear;

    public Car(int gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    public void setGear(int gear) {
        if (gear > gearsNumber || gear < 0) {
            throw new IllegalStateException();
        }
        this.gear = gear;
    }

    public void start() {
        engineStarted = true;
        setGear(1);
    }

    public void stop(){
        setGear(0);
        engineStarted = false;
    }
}
