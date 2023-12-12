package jetbrains.refactoring.course.moving.car;

public class Car {
    private final int gearsNumber;
    public boolean engineStarted;
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
}
