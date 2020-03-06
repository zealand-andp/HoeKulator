package beregnafskrivning;

import entities.exceptions.KanIkkeBeregneAfskrivningException;

public interface BeregnAfskrivning {
    void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) throws KanIkkeBeregneAfskrivningException;
}
