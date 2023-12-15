package jetbrains.refactoring.course.extracting;

public class Task {
    private static final double SPEED_OF_LIGHT = 299792458.0;
    private static final double PLANCK_CONSTANT = 6.62607015e-34;

    public static void main(String[] args) {
        double waveLength = 0.5e-6;

        double photonEnergy = calculatePhotonEnergy(waveLength);
        double photonMass = calculatePhotonMass(photonEnergy);

        System.out.println("Photon energy: " + photonEnergy + " Joules");
        System.out.println("Photon mass: " + photonMass + " kg");
    }

    public static double calculatePhotonEnergy(double waveLength) {
        double frequency = SPEED_OF_LIGHT / waveLength;
        return PLANCK_CONSTANT * frequency;
    }

    public static double calculatePhotonMass(double energy) {
        return energy / (SPEED_OF_LIGHT * SPEED_OF_LIGHT);
    }
}