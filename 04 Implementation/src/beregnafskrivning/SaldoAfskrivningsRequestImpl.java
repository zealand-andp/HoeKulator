package beregnafskrivning;

import entities.exceptions.NegativAfskrivningsprocentException;
import entities.exceptions.NegativBeloebException;

public class SaldoAfskrivningsRequestImpl implements SaldoAfskrivningRequest, AfskrivningRequest {
    private double anskaffelsVaerdi;
    private double afskrivningsProcent;
    private double beloeb;
    private boolean erBergenet;

    protected SaldoAfskrivningsRequestImpl(double anskaffelsVaerdi,double afskrivningsProcent) throws NegativBeloebException, NegativAfskrivningsprocentException {
        this.anskaffelsVaerdi=anskaffelsVaerdi;
        this.afskrivningsProcent=afskrivningsProcent;
    }

    @Override
    public boolean erBeregnet() {
        return erBergenet;
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