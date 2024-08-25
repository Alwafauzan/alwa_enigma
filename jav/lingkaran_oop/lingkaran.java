public class lingkaran {
    private int r;
    private final double pi = 3.14;

    
    public lingkaran() {
    }
    public lingkaran(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }

    public Boolean luas(int r, double pi){
        return pi*r*r;
    };

    @Override
    public String toString() {
        return "lingkaran [r=" + r + ", pi=" + pi + "]";
    }

    

    
}
