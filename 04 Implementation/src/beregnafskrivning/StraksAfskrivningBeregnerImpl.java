package beregnafskrivning;

import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;

public class StraksAfskrivningBeregnerImpl implements StraksAfskrivningBeregner {
    private double maksBeloeb = 14200;
    StraksAfskrivningsRequest straksAfskrivningsRequest;


    public void beregnAfskrivning(AfskrivningRequest request) throws NegativBeloebException, OverMaksbeloebException {
        if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.STRAKS) {
            return;
        }
        straksAfskrivningsRequest = (StraksAfskrivningsRequest) request;

        if (straksAfskrivningsRequest.hentAnskaffelsesvaerdi() <= 0) {
            throw new NegativBeloebException("Negativt beloeb");
        }
        if (straksAfskrivningsRequest.hentAnskaffelsesvaerdi()>maksBeloeb) {
            throw new OverMaksbeloebException("Over maks straksafskrivningsbeløb");
        }

        double resultat = straksAfskrivningsRequest.hentAnskaffelsesvaerdi();
        straksAfskrivningsRequest.angivAfskrivning(resultat);
    }
}