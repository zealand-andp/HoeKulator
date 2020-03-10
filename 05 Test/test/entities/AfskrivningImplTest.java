package entities;
import beregnafskrivning.AfskrivningsBeregner;
import beregnafskrivning.AfskrivningsRequest;
import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AfskrivningImplTest {
    @Test
    void angivStraksAfskrivning() {
        String navn = "cykler";
        double anskaffelsesvaerdi = 5000;
        AfskrivningImpl.angivStandardAfskrivningsBeregner(new MockStraksAfskrivningsBeregner());
        AfskrivningImpl afskrivning = new AfskrivningImpl(navn);
        afskrivning.angivStraksAfskrivning(anskaffelsesvaerdi);
        assertEquals(5000,afskrivning.hentAfskrivningsvaerdi());
    }

    private class MockStraksAfskrivningsBeregner implements AfskrivningsBeregner {
        @Override
        public void beregnAfskrivning(AfskrivningsRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException {
            request.angivAfskrivning(5000);
        }
    }
}

