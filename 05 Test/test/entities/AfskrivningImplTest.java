package entities;
import beregnafskrivning.AfskrivningRequest;
import beregnafskrivning.AfskrivningsBeregner;
import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AfskrivningImplTest {
    @Test
    void angivStraksAfskrivning() throws NegativVaerdiException, KanIkkeBeregneAfskrivningException, NegativAfskrivningsprocentException, OverMaksbeloebException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, NegativEllerNulVaerdiException {
        String navn = "cykler";
        double anskaffelsesvaerdi = 5000;
        AfskrivningImpl.AngivStandardafskrivningsberegner(new MockStraksAfskrivningsBeregner());
        AfskrivningImpl afskrivning = new AfskrivningImpl(navn);
        afskrivning.angivStraksafskrivning(anskaffelsesvaerdi);
        assertEquals(5000,afskrivning.hentAfskrivningsvaerdi());
    }

    private class MockStraksAfskrivningsBeregner implements AfskrivningsBeregner {

        @Override
        public void beregnAfskrivning(AfskrivningRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException, NegativAfskrivningsprocentException {
            request.angivAfskrivning(5000);
        }
    }
}

