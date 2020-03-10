package entities;

import beregnafskrivning.*;
import entities.exceptions.*;

public class AfskrivningImpl implements Afskrivning {
    private String navn;
    private int brugstid;
    private double scrapvaerdi;
    private double afskrivningsvaerdi;

    public AfskrivningImpl(String navn) {
        this.navn = navn;


    }


    @Override
    public void containsKey(String navn) {
    }

    @Override
    public void get(String navn) {

    }

    @Override
    public void put(String navn, Afskrivning afskrivning) {

    }


    @Override
    public void angivLineaerAfskrivning(double anskaffelsesvaerdi, double scrapvaerdi, int brugstid) throws KanIkkeBeregneAfskrivningException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, NegativAfskrivningsprocentException {
        LinearAfskrivningRequestImpl linearAfskrivningsRequest = new LinearAfskrivningRequestImpl(brugstid, anskaffelsesvaerdi, scrapvaerdi);
        LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner = new LinearAfskrivningsBeregnerImpl();
        linearAfskrivningsBeregner.beregnAfskrivning(linearAfskrivningsRequest);
        boolean erBeregnet = linearAfskrivningsRequest.erBeregnet();
        if (!erBeregnet) {
            throw new KanIkkeBeregneAfskrivningException();
        }
        afskrivningsvaerdi = linearAfskrivningsRequest.hentAfskrivning();


    }

    @Override
    public void angivSaldoafskrivning(double anskaffelsesvaerdi, double afskrivningsprocent) throws NegativAfskrivningsprocentException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, KanIkkeBeregneAfskrivningException {
        SaldoAfskrivningRequest saldoAfskrivningRequest = new SaldoAfskrivningsRequestImpl(anskaffelsesvaerdi, afskrivningsprocent);
        LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner = new LinearAfskrivningsBeregnerImpl();
        linearAfskrivningsBeregner.beregnAfskrivning(saldoAfskrivningRequest);
        boolean erBeregnet = saldoAfskrivningRequest.erBeregnet();
        if (!erBeregnet) {
            throw new KanIkkeBeregneAfskrivningException();
        }
        afskrivningsvaerdi = saldoAfskrivningRequest.hentAfskrivning();
    }

    @Override
    public void angivStraksafskrivning(double anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException, KanIkkeBeregneAfskrivningException {
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsesvaerdi);
        LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner = new LinearAfskrivningsBeregnerImpl();
        linearAfskrivningsBeregner.beregnAfskrivning(straksAfskrivningsRequest);
        boolean erBeregnet = straksAfskrivningsRequest.erBeregnet();
        if (!erBeregnet) {
            throw new KanIkkeBeregneAfskrivningException();
        }
        afskrivningsvaerdi = straksAfskrivningsRequest.hentAfskrivning();
    }
}
