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

    }

    @Override
    public double hentAfskrivning() {
        return 0;
    }

    public Afskrivningsmetoder hentAfskrivningsmetode() {
        return Afskrivningsmetoder.STRAKS;
    }

    @Override
    public double hentAnskaffelsesvaerdi() {
        return 0;
    }

    public StraksAfskrivningsRequestImpl(double anskaffelsesvaerdi) {
        this.anskaffelsesvaerdi = anskaffelsesvaerdi;
    }

}
