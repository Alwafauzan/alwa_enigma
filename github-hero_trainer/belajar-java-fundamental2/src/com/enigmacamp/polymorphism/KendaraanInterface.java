public interface KendaraanInterface {
    void bergerak();
    void berhenti();
}

public class Mobil implements KendaraanInterface {
    @Override
    public void bergerak() {
        System.out.println("Mobil bergerak");
    }

    @Override
    public void berhenti() {
        System.out.println("Mobil berhenti");
    }
}

public class Sepeda implements KendaraanInterface {
    @Override
    public void bergerak() {
        System.out.println("Sepeda bergerak");
    }

    @Override
    public void berhenti() {
        System.out.println("Sepeda berhenti");
    }
}