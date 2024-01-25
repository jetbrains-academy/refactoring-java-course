package jetbrains.refactoring.course.moving;

public class Car {
    private final int gearsNumber;
    private boolean engineStarted = false;
    private int gear = 0;

    public Car(int gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    private void setGear(int gear) {
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
