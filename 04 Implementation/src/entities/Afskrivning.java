package entities;

import beregnafskrivning.AfskrivningsBeregner;
import entities.exceptions.*;

public interface Afskrivning {
    void containsKey(String navn);
    void get(String navn);
    void put(String navn, Afskrivning afskrivning);
    void angivloneaerAfskrvning(double anskaffelsesvaerdi, double scrapvaerdi, int brugstid) throws KanIkkeBeregneAfskrivningException, NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException;

}
