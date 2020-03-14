package beregnsso;

public class BeregnSSOImpl implements BeregnSSO {
    private double sum;

    @Override
    public void angivSum(double sum) {
        this.sum = sum;
    }

    @Override
    public double hentSum() {
        return sum;
    }
}
