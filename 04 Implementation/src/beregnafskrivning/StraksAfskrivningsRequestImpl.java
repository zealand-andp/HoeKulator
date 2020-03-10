package beregnafskrivning;

public class StraksAfskrivningsRequestImpl implements StraksAfskrivningsRequest, AfskrivningRequest {
    double anskaffelsesvaerdi;
    double beloeb;
    boolean erBergenet;

    @Override
    public boolean erBeregnet() {
        return false;
    }

    @Override
    public void angivAfskrivning(double beloeb) {
        this.beloeb = beloeb;
        erBergenet = true;
    }

    @Override
    public double hentAfskrivning() {
        return beloeb;
    }

    public Afskrivningsmetoder hentAfskrivningsmetode() {
        return Afskrivningsmetoder.STRAKS;
    }

    @Override
    public double hentAnskaffelsesvaerdi() {
        return anskaffelsesvaerdi;
    }

    public StraksAfskrivningsRequestImpl(double anskaffelsesvaerdi) {
        this.anskaffelsesvaerdi = anskaffelsesvaerdi;
    }
}
