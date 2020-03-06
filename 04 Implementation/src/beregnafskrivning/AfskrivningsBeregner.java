package beregnafskrivning;

import entities.exceptions.*;

public interface AfskrivningsBeregner {
    void beregnAfskrivning(AfskrivningsRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException;
}
