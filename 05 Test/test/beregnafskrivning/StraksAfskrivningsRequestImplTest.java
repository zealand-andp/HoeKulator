package beregnafskrivning;

import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StraksAfskrivningsRequestImplTest {

    @Test void newStraksAfskrivningsRequest() throws NegativBeloebException, OverMaksbeloebException {
        double anskaffelsvaerdi = 5000;
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsvaerdi);

        assertEquals(5000, straksAfskrivningsRequest.hentAnskaffelsesvaerdi());
        assertEquals(Afskrivningsmetoder.STRAKS, straksAfskrivningsRequest.hentAfskrivningsmetode());
    }

    @Test void erBeregnet() throws NegativBeloebException, OverMaksbeloebException {
        double anskaffelsvaerdi = 5000;
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsvaerdi);
        straksAfskrivningsRequest.angivAfskrivning(5000);

        assertTrue(straksAfskrivningsRequest.erBeregnet());
    }

    @Test void hentAfskrivning() throws NegativBeloebException, OverMaksbeloebException, NegativVaerdiException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException {
        double anskaffelsvaerdi = 5000;
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsvaerdi);
        MockLinearAfskrivningsBeregner mockLinearAfskrivningsBeregner = new MockLinearAfskrivningsBeregner();
        mockLinearAfskrivningsBeregner.beregnAfskrivning((AfskrivningRequest) straksAfskrivningsRequest);
        assertEquals(5000, ((AfskrivningRequest) straksAfskrivningsRequest).hentAfskrivning());
    }

    @Test void hentAnskaffelsesvaerdi() throws NegativBeloebException, OverMaksbeloebException {
        double anskaffelsesvaerdi = 5000;
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsesvaerdi);
        assertEquals(5000, straksAfskrivningsRequest.hentAnskaffelsesvaerdi());
    }

    @Test void angivAfskrivning() throws NegativBeloebException, OverMaksbeloebException {
        double anskaffelsesvaerdi = 5000;
        StraksAfskrivningsRequestImpl straksAfskrivningsRequest = new StraksAfskrivningsRequestImpl(anskaffelsesvaerdi);
        straksAfskrivningsRequest.angivAfskrivning(anskaffelsesvaerdi);
        assertEquals(5000, straksAfskrivningsRequest.hentAfskrivning());
        assertTrue(straksAfskrivningsRequest.erBeregnet());

    }

    private class MockLinearAfskrivningsBeregner implements LinearAfskrivningsBeregner, AfskrivningsBeregner {

        @Override
        public void beregnAfskrivning(AfskrivningRequest request) throws NegativEllerNulVaerdiException, NegativVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, OverMaksbeloebException, NegativAfskrivningsprocentException {
            request.angivAfskrivning(5000);
        }
    }
}
