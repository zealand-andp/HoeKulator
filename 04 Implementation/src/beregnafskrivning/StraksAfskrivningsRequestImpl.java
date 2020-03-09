package beregnafskrivning;

import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;

public class StraksAfskrivningsRequestImpl implements StraksAfskrivningsRequest {
    private double anskaffelsesvaerdi;
//TODO når Afskrivningsmetoder er lavet
   // public Afskrivningsmetoder hentAfskrivningsmetode(){
     //   return Afskrivningsmetoder.STRAKS;     }

    public StraksAfskrivningsRequestImpl(double anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException {
        this.anskaffelsesvaerdi = anskaffelsesvaerdi;
    }

}
