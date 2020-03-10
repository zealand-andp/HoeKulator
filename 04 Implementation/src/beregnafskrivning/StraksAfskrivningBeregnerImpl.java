package beregnafskrivning;

import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;

public class StraksAfskrivningBeregnerImpl implements StraksAfskrivningBeregner {
    private double maksBeloeb=14100;


    /*TODO når AfskrivningRequest, Afskrivningsmetoder, hentAnskaffelsesvaerdi er lavet,
    public void beregnAfskrivning(AfskrivningRequest request) { // med s eller ej?
        if (request.hentAfskrivningsMetode()!=Afskrivningsmetoder.STRAKS) {
            return;
        }

        if (request.hentAnskaffelsesvaerdi()<0){
            throw new NegativBeloebException("Negativt beloeb");
        }
        if (request.hentAnskaffelsesvaerdi()>maksBeloeb) {
            throw new OverMaksbeloebException("Over maks straksafskrivningsbeløb");
        }

        double resultat=request.hentAnskaffelsesvaerdi();

        request.angivAfskrivning(resultat); }
 */
    }