package entities;

import beregnafskrivning.AfskrivningsBeregner;
import beregnafskrivning.LinearAfskrivningsBeregnerImpl;
import beregnafskrivning.LinearAfskrivningsRequestImpl;
import entities.exceptions.*;

public class AfskrivningImpl implements Afskrivning {
    private static AfskrivningsBeregner standardafskrivningsberegner = new LinearAfskrivningsBeregnerImpl();
    private String navn;
    private int brugstid;
    private double scrapvaerdi;
    private double afskrivningsvaerdi;

    public AfskrivningImpl(String navn) {
        this.navn = navn;


    }


    static void angivStandardAfskrivningsBeregner(AfskrivningsBeregner afskrivningsBeregner) {
        standardafskrivningsberegner = afskrivningsBeregner;
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
    public void angivloneaerAfskrvning(double anskaffelsesvaerdi, double scrapvaerdi, int brugstid) throws KanIkkeBeregneAfskrivningException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException {
        this.afskrivningsvaerdi = anskaffelsesvaerdi;
        LinearAfskrivningsRequestImpl linearAfskrivningsRequest = new LinearAfskrivningsRequestImpl( brugstid, anskaffelsesvaerdi, scrapvaerdi);
        LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner = new LinearAfskrivningsBeregnerImpl();
        linearAfskrivningsBeregner.beregnAfskrivning(linearAfskrivningsRequest);
       boolean erBeregnet = linearAfskrivningsRequest.erBeregnet();
        if (!erBeregnet){
            throw new KanIkkeBeregneAfskrivningException();
        }
      afskrivningsvaerdi =  linearAfskrivningsRequest.hentAfskrivning();


    }
}
