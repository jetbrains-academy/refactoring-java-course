package jetbrains.refactoring.course.moving;

public class Car {
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
