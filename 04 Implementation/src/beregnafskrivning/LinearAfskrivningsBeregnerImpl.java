package beregnafskrivning;

import entities.exceptions.*;


public class LinearAfskrivningsBeregnerImpl implements LinearAfskrivningsBeregner {

    double resultat;
    AfskrivningsBeregner afskrivningsBeregner;
    LinearAfskrivningRequestImpl linearAfskrivningsRequest;


    @Override
    public void beregnAfskrivning(AfskrivningRequest request) throws NegativEllerNulVaerdiException,
            NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException,
            NegativBeloebException, OverMaksbeloebException, NegativAfskrivningsprocentException {
       if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.LINEAER){
           afskrivningsBeregner = new SaldoAfskrivningBeregnerImpl();
           afskrivningsBeregner.beregnAfskrivning(request);
       }
        if (request.erBeregnet()) {
            return;
        }
       linearAfskrivningsRequest = (LinearAfskrivningRequestImpl) request;

       if (linearAfskrivningsRequest.hentBrugstid() <= 0){
           throw  new NegativEllerNulVaerdiException();
       }

       if (linearAfskrivningsRequest.hentAnskaffelsesvaerdi() <0){
           throw new NegativVaerdiException();
       }

       if (linearAfskrivningsRequest.hentScrapvaerdi() <0){
           throw  new NegativVaerdiException();
       }

       if (linearAfskrivningsRequest.hentScrapvaerdi() > request.hentAnskaffelsesvaerdi()){
           throw new ScrapvaerdiStoerreEndAnskaffelsesvaerdiException();
       }

       double anskaffelsevaerdi = linearAfskrivningsRequest.hentAnskaffelsesvaerdi();
       double scrapvaerdi = linearAfskrivningsRequest.hentScrapvaerdi();
       int brugstid = linearAfskrivningsRequest.hentBrugstid();

       this.resultat = (anskaffelsevaerdi-scrapvaerdi) / brugstid;
       linearAfskrivningsRequest.angivAfskrivning(this.resultat);
    }
}
