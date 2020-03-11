package beregnafskrivning;

import entities.Afskrivning;
import entities.exceptions.*;

import java.util.LinkedHashMap;

public interface BeregnAfskrivning {
    void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) throws KanIkkeBeregneAfskrivningException, NegativVaerdiException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativBeloebException, NegativAfskrivningsprocentException;
    void angivStraksafskrivning(String navn, double anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException, KanIkkeBeregneAfskrivningException;
    void angivSaldoafskrivning(String navn, double anskaffelsesvaerdi, double afskrivningsprocent) throws OverMaksbeloebException, KanIkkeBeregneAfskrivningException, NegativVaerdiException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, NegativAfskrivningsprocentException;
    LinkedHashMap<String, Afskrivning> hentAfskrivninger();
}
