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
       if (((LinearAfskrivningsRequest) request).hentBrugstid() <= 0){
           throw  new NegativEllerNulVaerdiException();
       }

       if (request.hentAnskaffelsesvaerdi() <0){
           throw new NegativVaerdiException();
       }

       if (((LinearAfskrivningsRequest) request).hentScrapvaerdi() <0){
           throw  new NegativVaerdiException();
       }

       if (((LinearAfskrivningsRequest) request).hentScrapvaerdi() > request.hentAnskaffelsesvaerdi()){
           throw new ScrapvaerdiStoerreEndAnskaffelsesvaerdiException();
       }

       double anskaffelsevaerdi = linearAfskrivningsRequest.hentAnskaffelsesvaerdi();
       double scrapvaerdi = linearAfskrivningsRequest.hentScrapvaerdi();
       int brugsTid = linearAfskrivningsRequest.hentBrugstid();

       this.resultat = (anskaffelsevaerdi-scrapvaerdi) / brugsTid;
       linearAfskrivningsRequest.angivAfskrivning(this.resultat);
    }
}
