package beregnafskrivning;

import entities.exceptions.*;

public class LinearAfskrivningsBeregnerImpl  implements AfskrivningsBeregner{
    double resultat;
    LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner;
    AfskrivningsBeregner afskrivningsBeregner;
    LinearAfskrivningsRequestImpl linearAfskrivningsRequest;


    @Override
    public void beregnAfskrivning(AfskrivningsRequest request) throws NegativEllerNulVaerdiException,
            NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException,
            NegativBeloebException, OverMaksbeloebException, NegativAfskrivningsprocentException {

       if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.LINEAER){
           afskrivningsBeregner.beregnAfskrivning(request);
       }
       if (request.hentBrugstid() <=0){
           throw  new NegativEllerNulVaerdiException();
       }

       if (request.hentAnskaffelsesvaedi() <0){
           throw new NegativVaerdiException();
       }

       if (request.hentScrapvaerdi() <0){
           throw  new NegativVaerdiException();
       }

       if (request.hentScrapvaerdi() > request.hentAnskaffelsesvaedi()){
           throw new ScrapvaerdiStoerreEndAnskaffelsesvaerdiException();
       }

       linearAfskrivningsRequest = (LinearAfskrivningsRequestImpl) request;
       double anskaffelsevaerdi = linearAfskrivningsRequest.hentAnskaffelsesvaedi();
       double scrapvaerdi = linearAfskrivningsRequest.hentScrapvaerdi();
       int brugsTid = linearAfskrivningsRequest.hentBrugstid();

       this.resultat = (anskaffelsevaerdi-scrapvaerdi) / brugsTid;
       linearAfskrivningsRequest.angivAfskrivning(this.resultat);
    }
}
