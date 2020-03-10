package entities;

import entities.exceptions.*;

public interface Afskrivning {
    void angivLineaerAfskrivning(double anskaffelsesvaerdi, double scrapvaerdi, int brugstid) throws KanIkkeBeregneAfskrivningException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, NegativAfskrivningsprocentException;
    void angivStraksafskrivning(double anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException, KanIkkeBeregneAfskrivningException;
    void angivSaldoafskrivning(double anskaffelsesvaerdi, double afskrivningsprocent) throws NegativAfskrivningsprocentException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, KanIkkeBeregneAfskrivningException;
    double hentAfskrivningsvaerdi();
}
