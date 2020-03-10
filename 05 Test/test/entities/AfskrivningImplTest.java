package entities;

import beregnafskrivning.AfskrivningsBeregner;
import beregnafskrivning.AfskrivningsRequest;
import beregnafskrivning.Afskrivningsmetoder;
import beregnafskrivning.StraksAfskrivningsRequest;
import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AfskrivningImplTest {

    @Test
    void newAfskrivning() {
        String navn = "Cykler";
        AfskrivningImpl afskrivning = new AfskrivningImpl(navn);
        assertEquals("Cykler", afskrivning.getNavn());
    }

    @Test
    void angivStraksAfskrivning() {
        double anskaffelsesvaerdi = 5000;
        String navn = "Cykler";
        AfskrivningImpl afskrivning = new AfskrivningImpl(navn);
        afskrivning.angivStraksAfskrivning(anskaffelsesvaerdi);
        assertEquals(5000, afskrivning.getAfskrivningsvaerdi());
    }

    private class MockAfskrivningsBeregner implements AfskrivningsBeregner {
        @Override
        public void beregnAfskrivning(AfskrivningsRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException {

        }
    }
}