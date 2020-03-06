package beregnafskrivning;

import entities.exceptions.*;

public class LinearAfskrivningsBeregnerImpl  implements AfskrivningsBeregner{
    double resultat;
    LinearAfskrivningsBeregnerImpl linearAfskrivningsBeregner;
    AfskrivningsBeregner afskrivningsBeregner;
    LinearAfskrivningsRequestImpl linearAfskrivningsRequest;


    @Override
    public void beregnAfskrivning(AfskrivningsRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException {

        if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.LINEAER){
           afskrivningsBeregner.beregnAfskrivning(request);
       }
            linearAfskrivningsRequest = (LinearAfskrivningsRequestImpl) request;
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
    }
}
