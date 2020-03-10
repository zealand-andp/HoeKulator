package beregnafskrivning;

import entities.exceptions.*;

public interface AfskrivningsBeregner {
    void beregnAfskrivning(AfskrivningRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException, NegativAfskrivningsprocentException;
}
