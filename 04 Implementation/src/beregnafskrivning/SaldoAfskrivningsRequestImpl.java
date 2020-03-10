package beregnafskrivning;


public class SaldoAfskrivningsRequestImpl implements SaldoAfskrivningRequest, AfskrivningRequest {
    private double anskaffelsVaerdi;
    private double afskrivningsProcent;
    private double beloeb;
    private boolean erBeregnet;

    public SaldoAfskrivningsRequestImpl(double anskaffelsVaerdi, double afskrivningsProcent) {
        this.anskaffelsVaerdi=anskaffelsVaerdi;
        this.afskrivningsProcent=afskrivningsProcent;
    }

    @Override
    public boolean erBeregnet() {
        return erBeregnet;
    }

    @Override
    public void angivAfskrivning(double beloeb) {
        this.beloeb = beloeb;
        erBeregnet = true;

    }

    @Override
    public double hentAfskrivning() {
        return beloeb;
    }

    @Override
    public Afskrivningsmetoder hentAfskrivningsmetode() {
        return Afskrivningsmetoder.SALDO;
    }

    @Override
    public double hentAnskaffelsesvaerdi() {
        return anskaffelsVaerdi;
    }

    @Override
    public double hentAfskrivningsProcent() {
        return afskrivningsProcent;
    }
}