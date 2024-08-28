public abstract class KendaraanAbstract {
    public abstract void bergerak();
    public abstract void berhenti();

    public void suara() {
        System.out.println("Kendaraan mengeluarkan suara");
    }
}

public class Mobil extends KendaraanAbstract {
    @Override
    public void bergerak() {
        System.out.println("Mobil bergerak");
    }

    @Override
    public void berhenti() {
        System.out.println("Mobil berhenti");
    }
}

public class Sepeda extends KendaraanAbstract {
    @Override
    public void bergerak() {
        System.out.println("Sepeda bergerak");
    }

    @Override
    public void berhenti() {
        System.out.println("Sepeda berhenti");
    }
}