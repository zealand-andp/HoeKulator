package entities;

import entities.exceptions.*;

public interface Afskrivning {
    void containsKey(String navn);
    void get(String navn);
    void put(String navn, Afskrivning afskrivning);
    void angivLineaerAfskrivning(double anskaffelsesvaerdi, double scrapvaerdi, int brugstid) throws KanIkkeBeregneAfskrivningException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, NegativAfskrivningsprocentException;
    void angivStraksafskrivning(double anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException, KanIkkeBeregneAfskrivningException;
    void angivSaldoafskrivning(double anskaffelsesvaerdi, double afskrivningsprocent) throws NegativAfskrivningsprocentException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, KanIkkeBeregneAfskrivningException;
}
