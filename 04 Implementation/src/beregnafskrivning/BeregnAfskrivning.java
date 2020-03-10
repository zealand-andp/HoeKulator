package beregnafskrivning;

import entities.exceptions.*;

public interface BeregnAfskrivning {
    void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) throws KanIkkeBeregneAfskrivningException, NegativVaerdiException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativBeloebException, NegativAfskrivningsprocentException;
    void angivStraksafskrivning(String navn, int anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException;
}
