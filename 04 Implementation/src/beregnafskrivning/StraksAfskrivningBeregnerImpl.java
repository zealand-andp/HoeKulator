package beregnafskrivning;

import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;

public class StraksAfskrivningBeregnerImpl implements StraksAfskrivningBeregner {
    private double maksBeloeb=14100;


    public void beregnAfskrivning(AfskrivningRequest request) throws NegativBeloebException, OverMaksbeloebException {
        if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.STRAKS) {
            return;
        }

        if (request.hentAnskaffelsesvaerdi() < 0) {
            throw new NegativBeloebException("Negativt beloeb");
        }
        if (request.hentAnskaffelsesvaerdi()>maksBeloeb) {
            throw new OverMaksbeloebException("Over maks straksafskrivningsbeløb");
        }

        double resultat = request.hentAnskaffelsesvaerdi();
        request.angivAfskrivning(resultat);
    }
}